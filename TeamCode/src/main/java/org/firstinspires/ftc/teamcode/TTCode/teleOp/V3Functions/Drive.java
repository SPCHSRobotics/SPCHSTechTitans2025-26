package org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.TTCode.robotInit.Bot;

public class Drive {
    Bot bot;
    Telemetry telemetry;
    public Drive(Bot bot, Telemetry telemetry) {
        this.bot = bot;
        this.telemetry = telemetry;
    }

    double MAX_DRIVE_SPEED = 1;

    public void drive(double x, double y, double turn) {

        // Finds direction and power based on coordinates
        double theta, power;
        theta = Math.atan2(y, x);
        power = Math.hypot(x, y);

        // Calculates power based on vectors and angles (I think)
        double sin, cos, max;
        sin = Math.sin(theta - Math.PI / 4);
        cos = Math.cos(theta - Math.PI / 4);
        max = Math.max(Math.abs(sin), Math.abs(cos));

        double frontLeftPower, frontRightPower, backLeftPower, backRightPower;
        frontLeftPower = power * cos / max + turn;
        frontRightPower = power * sin / max - turn;
        backLeftPower = power * sin / max + turn;
        backRightPower = power * cos / max - turn;

        // Ensures power doesn't exceed MAX_DRIVE_SPEED
        if (power + Math.abs(turn) > MAX_DRIVE_SPEED) {
            frontLeftPower /= power + turn;
            frontRightPower /= power + turn;
            backLeftPower /= power + turn;
            backRightPower /= power + turn;
        }

        // Assigns Motor Powers to each Motor
        bot.frontRightDrive.setPower(frontRightPower);
        bot.frontLeftDrive.setPower(frontLeftPower);
        bot.backRightDrive.setPower(backRightPower);
        bot.backLeftDrive.setPower(backLeftPower);
    }

    public void fieldCentricDrive(double x, double y, double turn) {
        // Define needed Variables
        double theta = Math.atan2(y, x);
        double r = Math.hypot(x, y);

        // Translate over to new inputs
        theta = AngleUnit.normalizeRadians(theta - bot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        // Outputs the new values
        double newX = r * Math.cos(theta);
        double newY = r * Math.sin(theta);

        // Drive using the drive function
        this.drive(newX, newY, turn);

        // Telemetry
        telemetry.addData("Heading", bot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES));
    }

    public void resetYaw(boolean pressed) {
        if (pressed) {
            bot.imu.resetYaw();
        }
    }

}
