package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock2;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class alexDriveTrainMock2 {

    // Defines Motor Names
    DcMotor frontRightDrive, frontLeftDrive, backRightDrive, backLeftDrive;

    public alexDriveTrainMock2(HardwareMap hardwareMap) {
        // Save the motors into the variable names
        frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");

        // Set Motor Directions
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    // Gamepad 1 (Start + Gamepad A)
    public void alexDrive(Gamepad gamepad, Telemetry telemetry) {

        // Takes polar coordinates as input through joysticks
        double x, y, turn;
        x = gamepad.left_stick_x;
        y = -gamepad.left_stick_y;
        turn = gamepad.right_stick_x;

        // Finds direction and power based on ^^
        double theta, power;
        theta = Math.atan2(y, x);
        power = Math.hypot(x, y);

        // Calculates power based on vectors and angles (I think)
        double sin, cos, max;
        sin = Math.sin(theta - Math.PI/4);
        cos = Math.cos(theta - Math.PI/4);
        max = Math.max(Math.abs(sin), Math.abs(cos));

        double frontLeftPower, frontRightPower, backLeftPower, backRightPower;
        frontLeftPower = power * cos/max + turn;
        frontRightPower = power * sin/max - turn;
        backLeftPower = power * sin/max + turn;
        backRightPower = power * cos/max - turn;

        // Ensures power doesn't exceed 1
        if (power + Math.abs(turn) > 1) {
            frontLeftPower /= power + turn;
            frontRightPower /= power + turn;
            backLeftPower /= power + turn;
            backRightPower /= power + turn;
        }

        // Test Motor Directions
        /*
        frontLeftPower  = gamepad.x ? 1.0 : 0.0;  // X gamepad
        backLeftPower   = gamepad.a ? 1.0 : 0.0;  // A gamepad
        frontRightPower = gamepad.y ? 1.0 : 0.0;  // Y gamepad
        backRightPower  = gamepad.b ? 1.0 : 0.0;  // B gamepad
        */

        // Assigns Motor Powers to each Motor
        frontRightDrive.setPower(frontRightPower);
        frontLeftDrive.setPower(frontLeftPower);
        backRightDrive.setPower(backRightPower);
        backLeftDrive.setPower(backLeftPower);

        // Telemetry
        telemetry.addData("frontRightPower", frontRightPower);
        telemetry.addData("frontLeftPower", frontLeftPower);
        telemetry.addData("backRightPower", backRightPower);
        telemetry.addData("backLeftPower", backLeftPower);
    }
}
