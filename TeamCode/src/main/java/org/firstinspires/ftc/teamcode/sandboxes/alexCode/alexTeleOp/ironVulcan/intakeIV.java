package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.ironVulcan;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class intakeIV {
    DcMotor intakeMotor;
    public void initIntake(HardwareMap hwMap) {
        intakeMotor = hwMap.get(DcMotor.class, "intakeMotor");
    }

    public void intake(Gamepad gamepad) {
        if (gamepad.x) {
            intakeMotor.setPower(0.5);
        } else {
            intakeMotor.setPower(0);
        }
    }
}
