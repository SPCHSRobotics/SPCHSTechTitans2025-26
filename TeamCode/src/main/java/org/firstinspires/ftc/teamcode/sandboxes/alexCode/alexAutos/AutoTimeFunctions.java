package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class AutoTimeFunctions {

    // opmode members
    DcMotor frontLeftDrive, backLeftDrive, frontRightDrive, backRightDrive;
    DcMotor leftShooter, rightShooter;
    DcMotor intakeMotor;

    // power constants
    final static double FORWARD_SPEED = 0.5;
    final static double TURN_SPEED = 1;
    final static double INTAKE_SPEED = -0.6;

    // misc
    private final ElapsedTime runtime = new ElapsedTime();
    alexSorriestAutoLongBlue main = new alexSorriestAutoLongBlue();

    public AutoTimeFunctions(HardwareMap hwMap) {
        frontLeftDrive = hwMap.get(DcMotor.class, "frontLeftDrive");
        backLeftDrive = hwMap.get(DcMotor.class, "backLeftDrive");
        frontRightDrive = hwMap.get(DcMotor.class, "frontRightDrive");
        backRightDrive = hwMap.get(DcMotor.class, "backRightDrive");

        intakeMotor = hwMap.get(DcMotor.class, "intakeMotor");

        leftShooter = hwMap.get(DcMotor.class, "leftShooter");
        rightShooter = hwMap.get(DcMotor.class, "rightShooter");

        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    public void moveForward(double duration) {
        frontLeftDrive.setPower(FORWARD_SPEED);
        backLeftDrive.setPower(FORWARD_SPEED);
        frontRightDrive.setPower(FORWARD_SPEED);
        backRightDrive.setPower(FORWARD_SPEED);

        runtime.reset();
        while (!main.opModeIsActive() && runtime.seconds() < duration) {
            main.telemetry.update();
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

        while (!main.opModeIsActive() && runtime.seconds() < duration) {
            main.telemetry.update();
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

        while (!main.opModeIsActive() && runtime.seconds() < duration) {
            main.telemetry.update();
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

        while (!main.opModeIsActive() && runtime.seconds() < duration) {
            main.telemetry.update();
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

        while (!main.opModeIsActive() && runtime.seconds() < duration) {
            main.telemetry.update();
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
        while (!main.opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            main.telemetry.update();
        }

        intakeMotor.setPower(INTAKE_SPEED);

        runtime.reset();
        while (!main.opModeIsActive() && runtime.seconds() < INTAKE_INTERVAL) {
            main.telemetry.update();
        }

        intakeMotor.setPower(INTAKE_HOLD);

        runtime.reset();
        while (!main.opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            main.telemetry.update();
        }

        intakeMotor.setPower(INTAKE_SPEED);

        runtime.reset();
        while (!main.opModeIsActive() && runtime.seconds() < INTAKE_INTERVAL) {
            main.telemetry.update();
        }

        intakeMotor.setPower(INTAKE_HOLD);

        runtime.reset();
        while (!main.opModeIsActive() && runtime.seconds() < SHOOTER_WAIT_TIME) {
            main.telemetry.update();
        }

        intakeMotor.setPower(INTAKE_SPEED);

        runtime.reset();
        while (!main.opModeIsActive() && runtime.seconds() < 1.0) {
            main.telemetry.update();
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
}
