package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.ironVulcan;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class shooterIV {
    DcMotor shooterMotor;
    public void initShooter(HardwareMap hwMap) {
        shooterMotor = hwMap.get(DcMotor.class, "shooterMotor");
    }

    public void shoot(Gamepad gamepad) {
        if (gamepad.a) {
            shooterMotor.setPower(0.4);
        } else {
            shooterMotor.setPower(0);
        }
    }
}
