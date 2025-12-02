package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock1;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class alexShooterMock1 {
    DcMotor leftShooter;
    DcMotor rightShooter;

    public alexShooterMock1(HardwareMap hardwareMap) {
        leftShooter = hardwareMap.get(DcMotor.class, "leftShooter");
        rightShooter = hardwareMap.get(DcMotor.class, "rightShooter");
    }

    public void shooterTTfx(Gamepad gamepad, Telemetry telemetry) {
        // gamepad 2

        // Shoots artifact
        if (gamepad.a) {
            leftShooter.setPower(-0.5);
            rightShooter.setPower(-0.5);
            telemetry.addData("Shooter Status", "Out");
        } else {
            leftShooter.setPower(0);
            rightShooter.setPower(0);
            telemetry.addData("Shooter Status", "Off");
        }
    }
    /*public void shitterTTfx(Gamepad gamepad, Telemetry telemetry) {

        if (gamepad.x) {
            leftShooter.setPower(0.2);
            rightShooter.setPower(0.2);
            telemetry.addData("Shooter Status", "In");
        } else {
            leftShooter.setPower(0);
            rightShooter.setPower(0);
            telemetry.addData("Shooter Status", "Off");
        }
    }*/
}

