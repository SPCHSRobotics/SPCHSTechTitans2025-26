package org.firstinspires.ftc.teamcode.TTCode.auto.autonomousFunctions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name="Test Encoders")
public class encoderTests extends LinearOpMode {
    DcMotor
            leftShooter, rightShooter,
            intakeMotor;

    public void runOpMode() {
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        leftShooter = hardwareMap.get(DcMotor.class, "leftShooter");
        rightShooter = hardwareMap.get(DcMotor.class, "rightShooter");

        leftShooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightShooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftShooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightShooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addLine("Ready to run");
        waitForStart();

        while (opModeIsActive()) {
            int rightShooterPosition = rightShooter.getCurrentPosition();
            int intakeMotorPosition = intakeMotor.getCurrentPosition();

            telemetry.addData("Right Shooter Ticks", rightShooterPosition);
            telemetry.addData("Intake Motor Ticks", intakeMotorPosition);
            telemetry.update();
        }

    }

}
