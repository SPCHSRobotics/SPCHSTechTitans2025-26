package org.firstinspires.ftc.teamcode.TTCode.teleOp;

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
    public void intakeTTfx(Gamepad gamepad, Telemetry telemetry) {

        if (gamepad.a) {
            intakeMotor.setPower(1);
            telemetry.addData("Intake Status", "Forward");
        } else {
            intakeMotor.setPower(0);
            telemetry.addData("Intake Status", "Off");
        }

    }

    public void outtakeTTfx(Gamepad gamepad, Telemetry telemetry) {

        if (gamepad.b) {
            intakeMotor.setPower(-0.5);
            telemetry.addData("Intake Status", "Backward");
        } else {
            intakeMotor.setPower(0);
            telemetry.addData("Intake Status", "Off");
        }
    }
}



