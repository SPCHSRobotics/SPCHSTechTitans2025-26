package org.firstinspires.ftc.teamcode.alexCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
//Delete this ^^ if you are just testing Shooter, also you cannot have two TeleOps both names Titan OpMode, they will break the Driver hub lol
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
            while (gamepad2.a) {
                shooterMotor1.setPower(1);
                shooterMotor2.setPower(-1);
            }
        }
    }


}

