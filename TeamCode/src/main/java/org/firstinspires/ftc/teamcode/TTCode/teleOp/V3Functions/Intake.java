package org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.TTCode.robotInit.Bot;

public class Intake {

    Bot bot;
    ElapsedTime runtime;
    Telemetry telemetry;
    public Intake(Bot bot, ElapsedTime runtime, Telemetry telemetry) {
        this.bot = bot;
        this.runtime = runtime;
        this.telemetry = telemetry;
    }

    double INTAKE_POWER = -1;
    double OUTTAKE_POWER = 0.3;

    public void intake(boolean active) {
        if (active) {
            bot.intakeMotor.setPower(INTAKE_POWER);
            telemetry.addData("Intake", "On");
        } else {
            bot.intakeMotor.setPower(0);
            telemetry.addData("Intake", "Off");
        }
    }

    public void outtake(boolean active) {
        if (active) {
            bot.intakeMotor.setPower(OUTTAKE_POWER);
            telemetry.addData("Outtake", "On");
        } else {
            bot.intakeMotor.setPower(0);
            telemetry.addData("Outtake", "Off");
        }
    }

}
