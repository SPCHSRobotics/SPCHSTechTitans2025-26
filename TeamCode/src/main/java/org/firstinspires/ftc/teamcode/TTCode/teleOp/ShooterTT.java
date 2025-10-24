package org.firstinspires.ftc.teamcode.TTCode.teleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class ShooterTT {
    DcMotor leftShooter;
    DcMotor rightShooter;

    public ShooterTT(HardwareMap hardwareMap) {
        leftShooter = hardwareMap.get(DcMotor.class, "leftShooter");
        rightShooter = hardwareMap.get(DcMotor.class, "rightShooter");
    }

    public void shooterTTfx(Gamepad gamepad, Telemetry telemetry) {
        // gamepad 2
        if (gamepad.y) {
            leftShooter.setPower(-0.4);
            rightShooter.setPower(-0.4);
            telemetry.addData("Shooter Status", "Out");
        } else {
            leftShooter.setPower(0);
            rightShooter.setPower(0);
            telemetry.addData("Shooter Status", "Off");
        }
    }
    public void shitterTTfx(Gamepad gamepad, Telemetry telemetry) {

        if (gamepad.x) {
            leftShooter.setPower(0.2);
            rightShooter.setPower(0.2);
            telemetry.addData("Shooter Status", "In");
        } else {
            leftShooter.setPower(0);
            rightShooter.setPower(0);
            telemetry.addData("Shooter Status", "Off");
        }
    }
}

