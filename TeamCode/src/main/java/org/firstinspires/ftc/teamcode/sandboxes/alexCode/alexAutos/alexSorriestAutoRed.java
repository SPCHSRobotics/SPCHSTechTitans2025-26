package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "alexAuto short red")
public class alexSorriestAutoRed extends LinearOpMode {
    /* Declare OpMode members. */
    private DcMotor backLeftDrive;
    private DcMotor frontLeftDrive;
    private DcMotor backRightDrive;
    private DcMotor frontRightDrive;
    private DcMotor leftShooter;
    private DcMotor rightShooter;
    private DcMotor intakeMotor;


    private ElapsedTime runtime = new ElapsedTime();


    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 0.5;
    static final double REVERSE_SPEED = -0.4;

    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");

        leftShooter = hardwareMap.get(DcMotor.class, "leftShooter");
        rightShooter = hardwareMap.get(DcMotor.class, "rightShooter");

        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();

        // Step through each leg of the path, ensuring that the OpMode has not been stopped along the way.

        // Step 1:  Drive reverse for 1 second
        frontLeftDrive.setPower(REVERSE_SPEED);
        backLeftDrive.setPower(REVERSE_SPEED);
        frontRightDrive.setPower(REVERSE_SPEED);
        backRightDrive.setPower(REVERSE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.2)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);

        leftShooter.setPower(-0.5);
        rightShooter.setPower(-0.5);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.5)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        intakeMotor.setPower(-0.6);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.13)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        intakeMotor.setPower(0);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.5)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        intakeMotor.setPower(-0.6);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.13)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        intakeMotor.setPower(0);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.5)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        intakeMotor.setPower(-0.6);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        intakeMotor.setPower(0);
        leftShooter.setPower(0);
        rightShooter.setPower(0);

        frontLeftDrive.setPower(FORWARD_SPEED);
        backLeftDrive.setPower(FORWARD_SPEED);
        frontRightDrive.setPower(FORWARD_SPEED);
        backRightDrive.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.3)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        frontLeftDrive.setPower(FORWARD_SPEED);
        backLeftDrive.setPower(-FORWARD_SPEED);
        frontRightDrive.setPower(-FORWARD_SPEED);
        backRightDrive.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.3)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);

        // Step 2:  Spin right for 1.3 seconds
        /*
        leftDrive.setPower(TURN_SPEED);dw
        rightDrive.setPower(-TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 3:  Drive Backward for 1 Second
        leftDrive.setPower(-FORWARD_SPEED);
        rightDrive.setPower(-FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 3: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        } */

        // Step 4:  Stop

    }
}
