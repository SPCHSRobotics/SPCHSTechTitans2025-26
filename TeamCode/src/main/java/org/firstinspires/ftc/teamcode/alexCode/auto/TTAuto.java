package org.firstinspires.ftc.teamcode.alexCode.auto;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class TTAuto extends LinearOpMode {

    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;

    private ElapsedTime runtime = new ElapsedTime();

    static final double COUNTS_PERMOTOR_REV = 537.6;
    static final double DRIVE_GEAR_REDUCTION = 1;
    static final double WHEEL_DIAMETER_INCHES = 4.094;
    static final double COUNTS_PER_INCHES = (COUNTS_PERMOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);
    static final double DRIVE_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;

    @Override
    public void runOpMode() {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        backLeft = hardwareMap.get(DcMotor.class, "backLeftDrive");
        frontRight = hardwareMap.get(DcMotor.class, "frontRightDrive");
        backRight = hardwareMap.get(DcMotor.class, "backRightDrive");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Drive Motors", "frontLeft: %d frontRight: %d backLeft: %d backRight: %d");
        telemetry.update();

        waitForStart();

        // action code here
        encoderDrive(1, 1,1,,1,20);



    }
    public void encoderDrive(double speed, double frontLeftInches, double backLeftInches, double frontRightInches, double backRightInches, double timeoutSec) {

        int newfrontLeftTarget = frontLeft.getCurrentPosition() + (int)(frontLeftInches*COUNTS_PER_INCHES);
        int newbackLeftTarget = frontLeft.getCurrentPosition() + (int)(backLeftInches*COUNTS_PER_INCHES);
        int newfrontRightTarget = frontLeft.getCurrentPosition() + (int)(frontRightInches*COUNTS_PER_INCHES);
        int newbackRightTarget = frontLeft.getCurrentPosition() + (int)(backRightInches*COUNTS_PER_INCHES);

        frontLeft.setTargetPosition(newfrontLeftTarget);
        backLeft.setTargetPosition(newbackLeftTarget);
        frontRight.setTargetPosition(newfrontRightTarget);
        backRight.setTargetPosition(newbackRightTarget);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(Math.abs(speed));
        backLeft.setPower(Math.abs(speed));
        frontRight.setPower(Math.abs(speed));
        backRight.setPower(Math.abs(speed));

        // while (opModeIsActive() && runtime.seconds() < timeoutSec && frontLeft.isBusy() && backLeft.isBusy() && frontRight.isBusy() && backRight.isBusy()) {}

        frontLeft.setPower(0.0);
        backLeft.setPower(0.0);
        frontRight.setPower(0.0);
        backRight.setPower(0.0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        sleep(250);

    }
}
