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
    final int MAX_TRANSFER_RPM = 180;


    // timing
    final double SHOOTER_WAIT_TIME = 3;


    // positions
    final double INTAKE1_ROTATIONS = 1.0;
    final int INTAKE1_TARGET = (int) Math.round(INTAKE1_ROTATIONS * INTAKE_TICKS_PER_REVOLUTION);

    final double INTAKE2_ROTATIONS = 2.5;
    final int INTAKE2_TARGET = (int) Math.round(INTAKE2_ROTATIONS * INTAKE_TICKS_PER_REVOLUTION);

    final double INTAKE3_ROTATIONS = 5;
    final int INTAKE3_TARGET = (int) Math.round(INTAKE3_ROTATIONS * INTAKE_TICKS_PER_REVOLUTION);


    // Functions
    public void transfer() {
        bot.intakeMotor.setVelocity(tps(MAX_TRANSFER_RPM, INTAKE_TICKS_PER_REVOLUTION));

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < 10) {
            opMode.telemetry.update();
        }

        bot.intakeMotor.setPower(0);

    }

    public void transferV2() {
        bot.intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        bot.intakeMotor.setTargetPosition(INTAKE1_TARGET);

        bot.intakeMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.intakeMotor.setVelocity(tps(MAX_TRANSFER_RPM, INTAKE_TICKS_PER_REVOLUTION));

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < 5) {
            opMode.telemetry.update();
        }

        bot.intakeMotor.setTargetPosition(INTAKE2_TARGET);

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < 5) {
            opMode.telemetry.update();
        }

        bot.intakeMotor.setTargetPosition(INTAKE3_TARGET);

        runtime.reset();
        while (opMode.opModeIsActive() && runtime.seconds() < 5) {
            opMode.telemetry.update();
        }

        bot.intakeMotor.setPower(0);
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
