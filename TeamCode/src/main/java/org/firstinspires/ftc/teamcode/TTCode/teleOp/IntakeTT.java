package org.firstinspires.ftc.teamcode.TTCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeTT {
    public DcMotor intakeMotor;
    public IntakeTT(HardwareMap hardwareMap) {

        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

    }
    // Gamepad 2
    public boolean isOn = false;
    public void intakeTTfx(Gamepad gamepad, Telemetry telemetry) {

        if (gamepad.b) {
            if (isOn) {
                intakeMotor.setPower(0);
                isOn = false;
            } else {
                intakeMotor.setPower(0.5);
                isOn = true;
            }
        }
    }
}



