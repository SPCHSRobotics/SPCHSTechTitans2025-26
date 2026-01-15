package org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.TTCode.robotInit.Bot;

public class Intake {
    Bot bot;
    Telemetry telemetry;
    public Intake(Bot bot, Telemetry telemetry) {
        this.bot = bot;
        this.telemetry = telemetry;
    }

    double INTAKE_POWER = -0.3;
    double OUTTAKE_POWER = 0.3;

    public void intake(Boolean intakeActive, Boolean outtakeActive) {

        if (intakeActive) {
            bot.intakeMotor.setPower(INTAKE_POWER);
            telemetry.addData("Intake", "On");
        } else if (outtakeActive) {
            bot.intakeMotor.setPower(OUTTAKE_POWER);
            telemetry.addData("Outtake", "On");
        } else {
            bot.intakeMotor.setPower(0);
            telemetry.addData("Intake", "Off");
        }
    }

}
