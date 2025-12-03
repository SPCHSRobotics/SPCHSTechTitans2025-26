package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock2;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


// Gamepad 1 (Start + Gamepad A)
public class AlexDriveTrainMock2 {

    // Defines hardware names
    DcMotor frontRightDrive, frontLeftDrive, backRightDrive, backLeftDrive;
    IMU imu;

    public void initDriveMotors(HardwareMap hardwareMap) {
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

        // Initialize IMU
        IMU imu = hardwareMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot revHubOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );

        imu.initialize(new IMU.Parameters(revHubOrientation));
    }

    // code (untested) to drive using vectors and angles for more accurate driving
    public void alexDriveV2(double x, double y, double turn) {

        // Finds direction and power based on coordinates
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

        // Assigns Motor Powers to each Motor
        frontRightDrive.setPower(frontRightPower);
        frontLeftDrive.setPower(frontLeftPower);
        backRightDrive.setPower(backRightPower);
        backLeftDrive.setPower(backLeftPower);

    }

    // Basic code for mecanum wheels
    public void alexDriveV1(double x, double y, double turn) {
        double max;

        double frontLeftPower  = y + x + turn;
        double frontRightPower = y - x - turn;
        double backLeftPower   = y - x + turn;
        double backRightPower  = y + x - turn;


        max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
        max = Math.max(max, Math.abs(backLeftPower));
        max = Math.max(max, Math.abs(backRightPower));

        if (max > 0.30) {
            frontLeftPower  /= max;
            frontRightPower /= max;
            backLeftPower   /= max;
            backRightPower  /= max;
        }

        frontRightDrive.setPower(frontRightPower);
        frontLeftDrive.setPower(frontLeftPower);
        backRightDrive.setPower(backRightPower);
        backLeftDrive.setPower(backLeftPower);
    }

    // code to make sure motors go the right directions
    public void motorDirectionTest(Gamepad gamepad) {
        double frontLeftPower, backLeftPower, frontRightPower, backRightPower;

        // Test Motor Directions
        frontLeftPower  = gamepad.x ? 1.0 : 0.0;  // X gamepad
        backLeftPower   = gamepad.a ? 1.0 : 0.0;  // A gamepad
        frontRightPower = gamepad.y ? 1.0 : 0.0;  // Y gamepad
        backRightPower  = gamepad.b ? 1.0 : 0.0;  // B gamepad

        frontRightDrive.setPower(frontRightPower);
        frontLeftDrive.setPower(frontLeftPower);
        backRightDrive.setPower(backRightPower);
        backLeftDrive.setPower(backLeftPower);
    }

    // code for a field centric drive using the first version drive code
    public void alexFieldCentricDrive(double x, double y, double turn) {
        double theta = Math.atan2(y, x);
        double r = Math.hypot(x, y);

        theta = AngleUnit.normalizeRadians(theta - imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        double newY = r * Math.sin(theta);
        double newX = r * Math.cos(theta);

        this.alexDriveV1(newX, newY, turn);
    }

    // code for a field centric drive using the second version drive code
    public void alexFieldCentricDriveV2(double x, double y, double turn) {
        double theta = Math.atan2(y, x);
        double r = Math.hypot(x, y);

        theta = AngleUnit.normalizeRadians(theta - imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        double newX = r * Math.cos(theta);
        double newY = r * Math.sin(theta);

        this.alexDriveV2(newX, newY, turn);
    }
}
