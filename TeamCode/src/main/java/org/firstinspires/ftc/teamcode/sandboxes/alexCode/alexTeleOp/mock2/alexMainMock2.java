package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock2;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp (name="Alex's Cucumber TeleOp")
public class alexMainMock2 extends LinearOpMode {
    // runtime
    private final ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() {

        // initialize hardware
        alexDriveTrainMock2 alexDrivers = new alexDriveTrainMock2(hardwareMap); // drive train

        // status ready
        telemetry.addData("Status", "Ready to Rumble");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            // robot functions
            alexDrivers.alexDrive(gamepad1, telemetry);

            // telemetry
            telemetry.addData("Runtime", runtime);
            telemetry.update();
        }
    }
}
