package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Alex's Cucumber TeleOp")
public class alexMainMock2 extends OpMode {

    // calls classes into main
    AlexDriveTrainMock2 driveTrain = new AlexDriveTrainMock2();

    public void init() {
        // initialize hardware
        driveTrain.initDriveMotors(hardwareMap);

    }

    public void loop() {
        // inputs

        // drivetrain
        double x, y, turn;
        x = gamepad1.left_stick_x;
        y = -gamepad1.left_stick_y;
        turn = gamepad1.right_stick_x;
        
        // -----------------------------------------------------------------------
        // robot functions
        /* driveTrain.motorDirectionTest(gamepad1); //Tests motor directions */
        driveTrain.alexFieldCentricDrive(x,y,turn); // drives from the perspective of the field

    }
}
