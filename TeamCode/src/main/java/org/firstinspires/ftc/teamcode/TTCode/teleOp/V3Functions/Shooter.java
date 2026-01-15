package org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.TTCode.robotInit.Bot;

public class Shooter {
    Bot bot;
    Telemetry telemetry;
    public Shooter(Bot bot, Telemetry telemetry) {
        this.bot = bot;
        this.telemetry = telemetry;
    }

    double SHOOTER_POWER = 0.52;

    public void shooter(boolean active) {
        if (active) {
            bot.leftShooter.setPower(SHOOTER_POWER);
            bot.rightShooter.setPower(SHOOTER_POWER);
            telemetry.addData("Shooter", "On");
        } else {
            bot.leftShooter.setPower(0);
            bot.rightShooter.setPower(0);
            telemetry.addData("Shooter", "Off");
        }
    }
}
