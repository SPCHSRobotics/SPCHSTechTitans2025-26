package org.firstinspires.ftc.teamcode.alexCode.teleOp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

/* i bought a usb-a to usb-c adapter
--to put on the orange dongle-- inside of the white big toolbox (big bottom right drawer, please return it to original home after use*/

@TeleOp (name="Tech Titans OpMode", group="Linear OpMode")
public class TeleOpMainTT extends LinearOpMode {
    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // Init Hardware
        DriveTT driversTT = new DriveTT(hardwareMap);
        ShooterTT shooterTT = new ShooterTT(hardwareMap);
        IntakeTT intakeTT = new IntakeTT(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            // Robot Functions
            driversTT.driveTT(gamepad1, telemetry);
            shooterTT.shooterTT(gamepad2, telemetry);
            intakeTT.intakeTT(gamepad2, telemetry);


            // Telemetry (will do later)

        }

    }

}
