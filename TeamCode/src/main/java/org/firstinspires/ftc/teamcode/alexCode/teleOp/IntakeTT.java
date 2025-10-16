package org.firstinspires.ftc.teamcode.alexCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
//Delete this ^^ if you are just testing Intake, also you cannot have two TeleOps both names Titan OpMode, they will break the Driver hub lol
@TeleOp (name="Titan OpMode", group="Linear OpMode")
public class IntakeTT extends LinearOpMode {
    DcMotor intakeMotor;

    @Override
    public void runOpMode() {

        intakeMotor = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        boolean isOn = false;

        waitForStart();
        while (opModeIsActive()) {

            if (gamepad2.b) {
                if (!isOn) {
                    intakeMotor.setPower(0.5);
                    isOn = true;
                }
                if (isOn) {
                    intakeMotor.setPower(0);
                    isOn = false;
                }
            }

        }
    }
}


