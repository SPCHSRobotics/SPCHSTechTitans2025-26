package org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.TTCode.robotInit.Bot;

public class Shooter {
    Bot bot;
    ElapsedTime runtime;
    Telemetry telemetry;
    public Shooter(Bot bot, ElapsedTime runtime, Telemetry telemetry) {
        this.bot = bot;
        this.runtime = runtime;
        this.telemetry = telemetry;
    }

    double SHOOTER_POWER = 0.52;

    public void shooter(boolean active) {
        if (active) {
            bot.intakeMotor.setPower(SHOOTER_POWER);
            telemetry.addData("Shooter", "On");
        } else {
            bot.intakeMotor.setPower(0);
            telemetry.addData("Shooter", "Off");
        }
    }
}
