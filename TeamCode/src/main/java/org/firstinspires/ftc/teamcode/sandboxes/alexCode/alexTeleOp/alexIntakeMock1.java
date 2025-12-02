package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class alexIntakeMock1 {
    public DcMotor intakeMotor;
    public alexIntakeMock1(HardwareMap hardwareMap) {

        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

    }
    // Gamepad 2
    public void intakeTTfx(Gamepad gamepad, Telemetry telemetry) {

        if (gamepad.b) {
            intakeMotor.setPower(0.7);
            telemetry.addData("Intake Status", "Forward");
        } else {
            intakeMotor.setPower(0);
            telemetry.addData("Intake Status", "Off");
        }

    }

    public void outtakeTTfx(Gamepad gamepad, Telemetry telemetry) {

        if (gamepad.x) {
            intakeMotor.setPower(-0.5);
            telemetry.addData("Intake Status", "Backward");
        } else {
            intakeMotor.setPower(0);
            telemetry.addData("Intake Status", "Off");
        }
    }
}



