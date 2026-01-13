package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos.autonomousFunctions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.sandboxes.alexCode.robotInit.Bot;

public class MovementFunctions {

    LinearOpMode opMode;
    Bot bot;
    ElapsedTime runtime;
    public MovementFunctions(LinearOpMode opMode, Bot bot, ElapsedTime runtime) {
        this.opMode = opMode;
        this.bot = bot;
        this.runtime = runtime;
    }

    // Power Constants
    final double FORWARD_POWER = 0.5;
    final double TURN_POWER = 1;

    // Functions
    public void forward(double duration) {
        bot.frontLeftDrive.setPower(FORWARD_POWER);
        bot.backLeftDrive.setPower(FORWARD_POWER);
        bot.frontRightDrive.setPower(FORWARD_POWER);
        bot.backRightDrive.setPower(FORWARD_POWER);

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < duration) {
            opMode.telemetry.update();
        }

        bot.frontLeftDrive.setPower(0);
        bot.backLeftDrive.setPower(0);
        bot.frontRightDrive.setPower(0);
        bot.backRightDrive.setPower(0);
    }

    public void turnLeft(double duration) {
        bot.frontLeftDrive.setPower(-TURN_POWER);
        bot.backLeftDrive.setPower(-TURN_POWER);
        bot.frontRightDrive.setPower(TURN_POWER);
        bot.backRightDrive.setPower(TURN_POWER);
        runtime.reset();

        while (opMode.opModeIsActive() && runtime.seconds() < duration) {
            opMode.telemetry.update();
        }

        bot.frontLeftDrive.setPower(0);
        bot.backLeftDrive.setPower(0);
        bot.frontRightDrive.setPower(0);
        bot.backRightDrive.setPower(0);
    }

    public void turnRight(double duration) {
        bot.frontLeftDrive.setPower(TURN_POWER);
        bot.backLeftDrive.setPower(TURN_POWER);
        bot.frontRightDrive.setPower(-TURN_POWER);
        bot.backRightDrive.setPower(-TURN_POWER);
        runtime.reset();

        while (opMode.opModeIsActive() && runtime.seconds() < duration) {
            opMode.telemetry.update();
        }

        bot.frontLeftDrive.setPower(0);
        bot.backLeftDrive.setPower(0);
        bot.frontRightDrive.setPower(0);
        bot.backRightDrive.setPower(0);
    }

    public void strafeLeft(double duration) {
        bot.frontLeftDrive.setPower(TURN_POWER);
        bot.backLeftDrive.setPower(-TURN_POWER);
        bot.frontRightDrive.setPower(-TURN_POWER);
        bot.backRightDrive.setPower(TURN_POWER);
        runtime.reset();

        while (opMode.opModeIsActive() && runtime.seconds() < duration) {
            opMode.telemetry.update();
        }

        bot.frontLeftDrive.setPower(0);
        bot.backLeftDrive.setPower(0);
        bot.frontRightDrive.setPower(0);
        bot.backRightDrive.setPower(0);
    }

    public void strafeRight(double duration) {
        bot.frontLeftDrive.setPower(-TURN_POWER);
        bot.backLeftDrive.setPower(TURN_POWER);
        bot.frontRightDrive.setPower(TURN_POWER);
        bot.backRightDrive.setPower(-TURN_POWER);
        runtime.reset();

        while (opMode.opModeIsActive() && runtime.seconds() < duration) {
            opMode.telemetry.update();
        }

        bot.frontLeftDrive.setPower(0);
        bot.backLeftDrive.setPower(0);
        bot.frontRightDrive.setPower(0);
        bot.backRightDrive.setPower(0);
    }

}
