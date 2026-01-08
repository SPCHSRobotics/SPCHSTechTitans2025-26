package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexTeleOp.ironVulcan;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="iron vulcan test")
public class mainIV extends OpMode {
    intakeIV intake = new intakeIV();
    shooterIV shooter = new shooterIV();

    public void init() {
        shooter.initShooter(hardwareMap);
        intake.initIntake(hardwareMap);
    }

    public void loop() {
        shooter.shoot(gamepad2);
        intake.intake(gamepad2);
    }
}
