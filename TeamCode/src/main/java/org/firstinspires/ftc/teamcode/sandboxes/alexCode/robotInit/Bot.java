package org.firstinspires.ftc.teamcode.sandboxes.alexCode.robotInit;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Bot {

    public DcMotor
            frontLeftDrive, backLeftDrive, frontRightDrive, backRightDrive;

    public DcMotorEx
            leftShooter, rightShooter,
            intakeMotor;

    public void initHardware(HardwareMap hwMap) {
        frontLeftDrive = hwMap.get(DcMotor.class, "frontLeftDrive");
        backLeftDrive = hwMap.get(DcMotor.class, "backLeftDrive");
        frontRightDrive = hwMap.get(DcMotor.class, "frontRightDrive");
        backRightDrive = hwMap.get(DcMotor.class, "backRightDrive");

        leftShooter = hwMap.get(DcMotorEx.class, "leftShooter");
        rightShooter = hwMap.get(DcMotorEx.class, "rightShooter");

        intakeMotor = hwMap.get(DcMotorEx.class, "intakeMotor");
    }

    public void setMotors() {
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        leftShooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightShooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void RUN_USING_ENCODERS() {
        leftShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
