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
        double intakePower = -0.7;
        double off = 0;
        if (on) {
            intakeMotor.setPower(intakePower);
            telemetry.addData("Intake", "On");
        } else {
            intakeMotor.setPower(off);
            telemetry.addData("Intake", "Off");
        }
    }

    public void outtake(Boolean on, Telemetry telemetry) {
        double outtakePower = 0.3;
        double off = 0;
        if (on) {
            intakeMotor.setPower(outtakePower);
            telemetry.addData("Outtake", "On");
        } else {
            intakeMotor.setPower(off);
            telemetry.addData("Outtake", "Off");
        }
    }
}
