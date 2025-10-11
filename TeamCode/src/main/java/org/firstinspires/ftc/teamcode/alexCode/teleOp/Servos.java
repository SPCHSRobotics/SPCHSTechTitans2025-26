package org.firstinspires.ftc.teamcode.alexCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "TTServo")
public class Servos extends LinearOpMode {
    public Servo intakeServo;
    public void init(HardwareMap hwMap) {
        intakeServo = hwMap.get(Servo.class, "nameofServo");
    }

    public void runOpMode() {
        init(hardwareMap);
        boolean intakeIsOn = true;
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad2.a) {
                if (intakeIsOn) {
                    intakeServo.setPosition(1);
                    intakeIsOn = false;
                } else {
                    intakeServo.setPosition(0.1);
                    intakeIsOn = true;
                }
            }

        }
    }
}
