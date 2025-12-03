package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock2;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp (name="Alex's Linear Cucumber TeleOp")
public class alexMainMock2Linear extends LinearOpMode {
    // runtime
    private final ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() {

        // initialize hardware
        AlexDriveTrainMock2 alexDrivers = new AlexDriveTrainMock2(); // drive train
        alexDrivers.initDriveMotors(hardwareMap);

        // status ready
        telemetry.addData("Status", "Ready to Rumble");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            // inputs

            // Drive Inputs
            double x, y, turn;
            x = gamepad1.left_stick_x;
            y = -gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;


            //---------------------------------------------------------
            // robot functions
            alexDrivers.alexDriveV2(x, y, turn);
            // alexDrivers.MotorDirectionTest(gamepad1);



            // telemetry
            telemetry.addData("Runtime", runtime);
            telemetry.update();
        }
    }
}
