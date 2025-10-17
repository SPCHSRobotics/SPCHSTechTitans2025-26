package org.firstinspires.ftc.teamcode.TTCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Disabled
public class IntakeTT {
    public DcMotor intakeMotor;
    public IntakeTT(HardwareMap hardwareMap) {

        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

    }
    //u should probably say if you are using gamepad 1 or 2 here
    public void intakeTT(Gamepad gamepad, Telemetry telemetry) {
        boolean isOn = false;
        if (gamepad.b) {
            if (!isOn) {
                intakeMotor.setPower(0.5);
                isOn = true;
            } if (isOn) {
                intakeMotor.setPower(0);
                isOn = false;
            }
        }
    }
}



