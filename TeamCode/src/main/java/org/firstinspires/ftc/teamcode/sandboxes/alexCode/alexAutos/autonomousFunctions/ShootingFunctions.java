package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos.autonomousFunctions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.sandboxes.alexCode.robotInit.Bot;

public class ShootingFunctions {

    LinearOpMode opMode;
    Bot bot;
    ElapsedTime runtime;
    public ShootingFunctions(LinearOpMode opMode, Bot bot, ElapsedTime runtime) {
        this.opMode = opMode;
        this.bot = bot;
        this.runtime = runtime;
    }

    // power constants
    final double INTAKE_POWER = -0.6;
    final double INTAKE_HOLD_POWER = -0.07;


    // tps conversion
    final int SHOOTER_TICKS_PER_REVOLUTION = 28;
    final int INTAKE_TICKS_PER_REVOLUTION = -103;


    // ticks per second (rotations per minute, ticks per revolution)
    public int tps(int rpm, int tpr) { return rpm / 60 * tpr; }

    // RPM's
    final int SHOOTER_RPM = 3900;
    final int MAX_TRANSFER_RPM = 60;


    // timing
    final double SHOOTER_WAIT_TIME = 2;


    // positions
    final double INTAKE_ROTATIONS = 7; // TODO To be measured
    final int INTAKE_TARGET = (int) Math.round(INTAKE_ROTATIONS * INTAKE_TICKS_PER_REVOLUTION);


    // Functions
    public void transfer() {

        final double INTAKE_INTERVAL = 0.13 ;

        bot.intakeMotor.setPower(INTAKE_POWER);

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < INTAKE_INTERVAL) {
            opMode.telemetry.update();
        }

        bot.intakeMotor.setPower(INTAKE_HOLD_POWER);

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            opMode.telemetry.update();
        }

        bot.intakeMotor.setPower(INTAKE_POWER);

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < INTAKE_INTERVAL) {
            opMode.telemetry.update();
        }

        bot.intakeMotor.setPower(INTAKE_HOLD_POWER);

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            opMode.telemetry.update();
        }

        bot.intakeMotor.setPower(INTAKE_POWER);

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < 1.0) {
            opMode.telemetry.update();
        }

        bot.intakeMotor.setPower(0);
    }

    public void transferV2() {
        bot.intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.intakeMotor.setTargetPosition(INTAKE_TARGET);
        bot.intakeMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.intakeMotor.setVelocity(tps(MAX_TRANSFER_RPM, INTAKE_TICKS_PER_REVOLUTION));
    }

    public void shoot() {

        bot.leftShooter.setVelocity(tps(SHOOTER_RPM, SHOOTER_TICKS_PER_REVOLUTION));
        bot.rightShooter.setVelocity(tps(SHOOTER_RPM, SHOOTER_TICKS_PER_REVOLUTION));

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            opMode.telemetry.update();
        }

        transfer();

        bot.leftShooter.setPower(0);
        bot.rightShooter.setPower(0);
    }
}
