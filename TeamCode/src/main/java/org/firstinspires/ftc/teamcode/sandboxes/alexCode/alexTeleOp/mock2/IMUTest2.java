package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.mock2;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@Disabled
@TeleOp(name="Test the IMU 2")
public class IMUTest2 extends LinearOpMode {
    YawPitchRollAngles robotOrientation;
    public void runOpMode() {
        IMU imu = hardwareMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot revHubOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );

        imu.initialize(new IMU.Parameters(revHubOrientation));
        imu.resetYaw();

        robotOrientation = imu.getRobotYawPitchRollAngles();

        waitForStart();
        while (opModeIsActive()) {
            double angle = robotOrientation.getYaw(AngleUnit.RADIANS);
            telemetry.addData("Angle", angle);
            double Yaw   = robotOrientation.getYaw(AngleUnit.RADIANS);
            double Pitch = robotOrientation.getPitch(AngleUnit.DEGREES);
            double Roll  = robotOrientation.getRoll(AngleUnit.DEGREES);
            telemetry.addData("Yaw", Yaw);
            telemetry.addData("Pitch", Pitch);
            telemetry.addData("Roll", Roll);
            telemetry.update();
        }
    }
}
