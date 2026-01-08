package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock2;

import android.sax.StartElementListener;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AlexShooterMock2 {
    DcMotor shooterMotorLeft, shooterMotorRight;

    public void initShooter(HardwareMap hwMap) {
        shooterMotorLeft = hwMap.get(DcMotor.class, "leftShooter");
        shooterMotorRight = hwMap.get(DcMotor.class, "rightShooter");
    }

    Boolean isActive = false;
    double shootingPower = 0.52;
    public void shooterFXToggle(Boolean pressed, Telemetry telemetry) {
        if (pressed) {
            if (!isActive) {
                shooterMotorLeft.setPower(-shootingPower);
                shooterMotorRight.setPower(-shootingPower);
                isActive = true;
            } else if (isActive) {
                shooterMotorLeft.setPower(0);
                shooterMotorRight.setPower(0);
                isActive = false;
            }
        }
    }

    public void shooterFXHold(Boolean pressed, Telemetry telemetry) {
        if (pressed) {
            shooterMotorLeft.setPower(-shootingPower);
            shooterMotorRight.setPower(-shootingPower);
        } else {
            shooterMotorLeft.setPower(0);
            shooterMotorRight.setPower(0);
        }
    }

}
