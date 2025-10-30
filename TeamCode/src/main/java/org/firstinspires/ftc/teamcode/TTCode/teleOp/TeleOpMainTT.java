package org.firstinspires.ftc.teamcode.TTCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

/* i bought a usb-a to usb-c adapter
--to put on the orange dongle-- inside of the white big toolbox (big bottom right drawer, please return it to original home after use*/

@TeleOp (name="Tech Titans OpMode Bot 1", group="Linear OpMode")
public class TeleOpMainTT extends LinearOpMode {
    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // Init Hardware
        DriveTT driversTT = new DriveTT(hardwareMap);
        ShooterTT shootersTT = new ShooterTT(hardwareMap);
        IntakeTT intakersTT = new IntakeTT(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            // Robot Functions

            // TODO: Add comments in the individual files to make more readable -Mentor Lucy
            driversTT.driveTTfx(gamepad1, telemetry);
            shootersTT.shooterTTfx(gamepad2, telemetry);
            intakersTT.intakeTTfx(gamepad2, telemetry);
            intakersTT.outtakeTTfx(gamepad2, telemetry);

            // Telemetry (will do later)
        }

    }

}
