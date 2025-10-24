package org.firstinspires.ftc.teamcode.TTCode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="Robot: Auto Drive By Time", group="Robot")
public class testingAuto extends LinearOpMode {

    private DcMotor         leftDrive   = null;
    private DcMotor         rightDrive  = null;

    private final ElapsedTime runtime = new ElapsedTime();

    static final double     FORWARD_SPEED = 0.6;

    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();

        leftDrive.setPower(FORWARD_SPEED);
        rightDrive.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        // Stop all motion
        leftDrive.setPower(0);
        rightDrive.setPower(0);

        // Let the driver know the autonomous path is complete
        telemetry.addData("Path", "Complete");
        telemetry.update();

        sleep(1000);
    }
}
