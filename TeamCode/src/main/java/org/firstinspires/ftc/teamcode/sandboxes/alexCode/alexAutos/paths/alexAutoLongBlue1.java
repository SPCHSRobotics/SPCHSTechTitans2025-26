package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos.paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous (name = "alexAuto long blue")
public class alexAutoLongBlue1 extends LinearOpMode {

    // opmode members
    DcMotor
            frontLeftDrive, backLeftDrive, frontRightDrive, backRightDrive;
    DcMotorEx
            leftShooter, rightShooter, intakeMotor;

    // power constants
    final double FORWARD_POWER = 0.5;
    final double TURN_POWER = 1;

    final double INTAKE_POWER = -0.6;
    final double INTAKE_HOLD_POWER = -0.07;


    // tps conversion
    final int SHOOTER_TICKS_PER_REVOLUTION = 28;
    final int INTAKE_TICKS_PER_REVOLUTION = -103;
    
    // ticks per second (rotations per minute, ticks per revolution)
    public int tps(int rpm, int tpr) {
        return rpm / 60 * tpr;
    }

    // RPM's
    final int SHOOTER_RPM = 3900;


    // Target positions



    // Runtime instantiation
    final ElapsedTime runtime = new ElapsedTime();

    // movement functions
    public void moveForward(double duration) {
        frontLeftDrive.setPower(FORWARD_POWER);
        backLeftDrive.setPower(FORWARD_POWER);
        frontRightDrive.setPower(FORWARD_POWER);
        backRightDrive.setPower(FORWARD_POWER);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < duration) {
            telemetry.update();
        }

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
    }

    public void turnLeft(double duration) {
        frontLeftDrive.setPower(-TURN_POWER);
        backLeftDrive.setPower(-TURN_POWER);
        frontRightDrive.setPower(TURN_POWER);
        backRightDrive.setPower(TURN_POWER);
        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < duration) {
            telemetry.update();
        }

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
    }

    public void turnRight(double duration) {
        frontLeftDrive.setPower(TURN_POWER);
        backLeftDrive.setPower(TURN_POWER);
        frontRightDrive.setPower(-TURN_POWER);
        backRightDrive.setPower(-TURN_POWER);
        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < duration) {
            telemetry.update();
        }

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
    }

    public void strafeLeft(double duration) {
        frontLeftDrive.setPower(TURN_POWER);
        backLeftDrive.setPower(-TURN_POWER);
        frontRightDrive.setPower(-TURN_POWER);
        backRightDrive.setPower(TURN_POWER);
        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < duration) {
            telemetry.update();
        }

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
    }

    public void strafeRight(double duration) {
        frontLeftDrive.setPower(-TURN_POWER);
        backLeftDrive.setPower(TURN_POWER);
        frontRightDrive.setPower(TURN_POWER);
        backRightDrive.setPower(-TURN_POWER);
        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < duration) {
            telemetry.update();
        }

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
    }

    // Shooter process
    final double SHOOTER_WAIT_TIME = 2;
    public void transfer() {

        final double INTAKE_INTERVAL = 0.13 ;

        intakeMotor.setPower(INTAKE_POWER);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < INTAKE_INTERVAL) {
            telemetry.update();
        }

        intakeMotor.setPower(INTAKE_HOLD_POWER);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            telemetry.update();
        }

        intakeMotor.setPower(INTAKE_POWER);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < INTAKE_INTERVAL) {
            telemetry.update();
        }

        intakeMotor.setPower(INTAKE_HOLD_POWER);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            telemetry.update();
        }

        intakeMotor.setPower(INTAKE_POWER);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 1.0) {
            telemetry.update();
        }

        intakeMotor.setPower(0);
    }

    public void transferV2() {

    }

    public void shoot() {

        leftShooter.setVelocity(tps(SHOOTER_RPM, SHOOTER_TICKS_PER_REVOLUTION));
        rightShooter.setVelocity(tps(SHOOTER_RPM, SHOOTER_TICKS_PER_REVOLUTION));

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            telemetry.update();
        }

        transfer();

        leftShooter.setPower(0);
        rightShooter.setPower(0);
    }

    public void end() {
        rightShooter.setPower(0);
        leftShooter.setPower(0);
        intakeMotor.setPower(0);
        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
    }

    @Override
    public void runOpMode() {

        // init
        frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
        leftShooter = hardwareMap.get(DcMotorEx.class, "leftShooter");
        rightShooter = hardwareMap.get(DcMotorEx.class, "rightShooter");

        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        leftShooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightShooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();

        // Main path
        moveForward(0.2);
        turnLeft(0.1);
        shoot();
        turnRight(0.08);
        strafeLeft(0.5);

        end();
        sleep(1000);
    }
}
