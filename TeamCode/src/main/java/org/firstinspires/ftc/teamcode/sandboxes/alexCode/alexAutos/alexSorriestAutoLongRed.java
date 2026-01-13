package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "alexAuto long red")
public class alexSorriestAutoLongRed extends LinearOpMode {

    // opmode members
    DcMotor frontLeftDrive, backLeftDrive, frontRightDrive, backRightDrive;
    DcMotor leftShooter, rightShooter;
    DcMotor intakeMotor;

    // power constants
    final double FORWARD_SPEED = 0.5;
    final double TURN_SPEED = 1;
    final double INTAKE_SPEED = -0.6;

    // misc
    final ElapsedTime runtime = new ElapsedTime();

    public void moveForward(double duration) {
        frontLeftDrive.setPower(FORWARD_SPEED);
        backLeftDrive.setPower(FORWARD_SPEED);
        frontRightDrive.setPower(FORWARD_SPEED);
        backRightDrive.setPower(FORWARD_SPEED);

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
        frontLeftDrive.setPower(-TURN_SPEED);
        backLeftDrive.setPower(-TURN_SPEED);
        frontRightDrive.setPower(TURN_SPEED);
        backRightDrive.setPower(TURN_SPEED);
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
        frontLeftDrive.setPower(TURN_SPEED);
        backLeftDrive.setPower(TURN_SPEED);
        frontRightDrive.setPower(-TURN_SPEED);
        backRightDrive.setPower(-TURN_SPEED);
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
        frontLeftDrive.setPower(TURN_SPEED);
        backLeftDrive.setPower(-TURN_SPEED);
        frontRightDrive.setPower(-TURN_SPEED);
        backRightDrive.setPower(TURN_SPEED);
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
        frontLeftDrive.setPower(-TURN_SPEED);
        backLeftDrive.setPower(TURN_SPEED);
        frontRightDrive.setPower(TURN_SPEED);
        backRightDrive.setPower(-TURN_SPEED);
        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < duration) {
            telemetry.update();
        }

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
    }

    public void shoot() {
        final double INTAKE_HOLD = -0.07;
        final double INTAKE_INTERVAL = 0.13 ;
        final double SHOOTER_POWER = -0.65;
        final double SHOOTER_WAIT_TIME = 4;

        leftShooter.setPower(SHOOTER_POWER);
        rightShooter.setPower(SHOOTER_POWER);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            telemetry.update();
        }

        intakeMotor.setPower(INTAKE_SPEED);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < INTAKE_INTERVAL) {
            telemetry.update();
        }

        intakeMotor.setPower(INTAKE_HOLD);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            telemetry.update();
        }

        intakeMotor.setPower(INTAKE_SPEED);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < INTAKE_INTERVAL) {
            telemetry.update();
        }

        intakeMotor.setPower(INTAKE_HOLD);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            telemetry.update();
        }

        intakeMotor.setPower(INTAKE_SPEED);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 1.0) {
            telemetry.update();
        }

        intakeMotor.setPower(0);
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
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        leftShooter = hardwareMap.get(DcMotor.class, "leftShooter");
        rightShooter = hardwareMap.get(DcMotor.class, "rightShooter");

        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);


        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();

        // Main path
        moveForward(0.2);
        turnRight(0.1);
        shoot();
        turnLeft(0.08);
        strafeRight(0.5);

        end();
        sleep(1000);

    }
}
