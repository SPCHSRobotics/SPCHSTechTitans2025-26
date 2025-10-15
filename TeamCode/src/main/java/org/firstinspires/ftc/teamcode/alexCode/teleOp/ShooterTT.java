package org.firstinspires.ftc.teamcode.alexCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Titan OpMode", group="Linear OpMode")
public class ShooterTT extends LinearOpMode {
    DcMotor shooterMotor1;
    DcMotor shooterMotor2;

    @Override
    public void runOpMode() {
        shooterMotor1 = hardwareMap.get(DcMotor.class, "shooterMotor1");
        shooterMotor2 = hardwareMap.get(DcMotor.class, "shooterMotor2");

        waitForStart();
        while (opModeIsActive()) {
            while (gamepad1.a) {
                shooterMotor1.setPower(1);
                shooterMotor2.setPower(-1);
            }
        }
    }


}

