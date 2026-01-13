package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos.autonomousFunctions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.sandboxes.alexCode.robotInit.Bot;

public class StatusFunctions {

    LinearOpMode opMode;
    Bot bot;
    ElapsedTime runtime;
    public StatusFunctions(LinearOpMode opMode, Bot bot, ElapsedTime runtime) {
        this.opMode = opMode;
        this.bot = bot;
        this.runtime = runtime;
    }

    public void end() {
        bot.rightShooter.setPower(0);
        bot.leftShooter.setPower(0);
        bot.intakeMotor.setPower(0);
        bot.frontLeftDrive.setPower(0);
        bot.backLeftDrive.setPower(0);
        bot.frontRightDrive.setPower(0);
        bot.backRightDrive.setPower(0);
    }
}
