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
        if (gamepad.a) {
            leftShooter.setPower(-1.0);
            rightShooter.setPower(1.0);
        } else {
            leftShooter.setPower(0);
            rightShooter.setPower(0);
        }
    }
}

