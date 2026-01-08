package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock2;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

@TeleOp(name="Alex's Cucumber TeleOp")
public class alexMainMock2 extends OpMode {

    // calls classes into main
    AlexDriveTrainMock2 driveTrain = new AlexDriveTrainMock2();
    AlexIntakeMock2 intake = new AlexIntakeMock2();
    AlexShooterMock2 shooter = new AlexShooterMock2();
    alexDriveMockV1 drive = new alexDriveMockV1();


    public void init() {
        // initialize hardware
        //driveTrain.initDriveMotors(hardwareMap);
        intake.initIntake(hardwareMap);
        shooter.initShooter(hardwareMap);
        drive.initAlexDriveV1(hardwareMap);

    }

    public void loop() {
        // inputs

        // drivetrain
        double x, y, turn;
        x = -gamepad1.left_stick_x;
        y = -gamepad1.left_stick_y;
        turn = gamepad1.right_stick_x;

        // Intake/Shooters
        boolean intakeHold, shooterHold, outtakeHold;
        intakeHold = gamepad2.a;
        shooterHold = gamepad2.b;
        outtakeHold = gamepad2.x;

        
        // -----------------------------------------------------------------------
        // robot functions
        //driveTrain.motorDirectionTest(gamepad1); //Tests motor directions */
        //driveTrain.alexFieldCentricDriveV2(x,y,turn); // drives from the perspective of the field
        intake.intake(intakeHold, telemetry);
        intake.outtake(outtakeHold, telemetry);
        shooter.shooterFXHold(shooterHold, telemetry);
        drive.driveTTfx(x, y, turn, telemetry);

    }
}
