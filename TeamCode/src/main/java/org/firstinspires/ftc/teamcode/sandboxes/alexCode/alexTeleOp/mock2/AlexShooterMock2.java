package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock2;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AlexShooterMock2 {
    DcMotor shooterMotor;

    public void initShooter(HardwareMap hwMap) {
        shooterMotor = hwMap.get(DcMotor.class, "shooterMotor");
    }

    Boolean isActive = false;
    double shootingPower = 0.3;
    public void shooterFXToggle(Boolean pressed, Telemetry telemetry) {
        if (pressed) {
            if (!isActive) {
                shooterMotor.setPower(shootingPower);
                isActive = true;
            } else if (isActive) {
                shooterMotor.setPower(0);
                isActive = false;
            }
        }
    }

    public void shooterFXHold(boolean pressed, Telemetry telemetry) {
        if (pressed) {
            shooterMotor.setPower(shootingPower);
        } else {
            shooterMotor.setPower(0);
        }
    }
}
