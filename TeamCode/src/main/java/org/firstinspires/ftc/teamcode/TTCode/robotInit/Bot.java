package org.firstinspires.ftc.teamcode.TTCode.robotInit;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class Bot {

    public DcMotor
            frontLeftDrive, backLeftDrive, frontRightDrive, backRightDrive;

    public DcMotorEx
            leftShooter, rightShooter,
            intakeMotor;

    public IMU
            imu;

    public void initHardware(HardwareMap hwMap) {
        frontLeftDrive = hwMap.get(DcMotor.class, "frontLeftDrive");
        backLeftDrive = hwMap.get(DcMotor.class, "backLeftDrive");
        frontRightDrive = hwMap.get(DcMotor.class, "frontRightDrive");
        backRightDrive = hwMap.get(DcMotor.class, "backRightDrive");

        leftShooter = hwMap.get(DcMotorEx.class, "leftShooter");
        rightShooter = hwMap.get(DcMotorEx.class, "rightShooter");
        intakeMotor = hwMap.get(DcMotorEx.class, "intakeMotor");

        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot revHubOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );

        imu.initialize(new IMU.Parameters(revHubOrientation));
        imu.resetYaw();
    }

    public void setMotors() {
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        leftShooter.setDirection(DcMotor.Direction.REVERSE);
        rightShooter.setDirection(DcMotor.Direction.REVERSE);

        leftShooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightShooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void RUN_USING_ENCODERS() {
        leftShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void RUN_WITHOUT_ENCODERS() {
        leftShooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightShooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
