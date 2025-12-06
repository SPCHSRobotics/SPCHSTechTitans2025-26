package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock2;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AlexIntakeMock2 {
    DcMotor intakeMotor;
    public void initIntake(HardwareMap hwMap) {
        intakeMotor = hwMap.get(DcMotor.class, "intakeMotor");
    }

    public void intake(Boolean on, Telemetry telemetry) {
        double intakePower = 0.5;
        double off = 0;
        if (on) {
            intakeMotor.setPower(intakePower);
        } else {
            intakeMotor.setPower(off);
        }
    }
}
