package org.firstinspires.ftc.teamcode.TTCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.TTCode.robotInit.Bot;
import org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions.Drive;
import org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions.Intake;
import org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions.Outtake;
import org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions.Shooter;

@TeleOp(name="THE Cucumber TeleOp")
public class Main extends OpMode {

    // Call Bot and Runtime in
    Bot bot = new Bot();
    ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {

        bot.initHardware(hardwareMap);
        bot.setMotors();

        bot.RUN_WITHOUT_ENCODERS();

        telemetry.addLine("Don't lose this Andy");
        telemetry.update();
    }

    Intake intake =  new Intake(bot, telemetry);
    Shooter shooter = new Shooter(bot, telemetry);
    Drive drive = new Drive(bot, telemetry);

    @Override
    public void loop() {
        /*---------Inputs---------*/
        // drivetrain
        double x, y, turn;
        boolean resetYaw;
        x = -gamepad1.left_stick_x;
        y = -gamepad1.left_stick_y;
        turn = gamepad1.right_stick_x;
        resetYaw = gamepad1.aWasPressed();

        // Intake/Shooters
        boolean intakeHold, shooterHold, outtakeHold;
        intakeHold = (gamepad2.right_trigger > 0.5);
        shooterHold = (gamepad2.left_trigger > 0.5);
        outtakeHold = gamepad2.a;
        /*------------------------*/

        // Functions
        intake.intake(intakeHold, outtakeHold);
        shooter.shooter(shooterHold);
        drive.fieldCentricDrive(x, y, turn);
        drive.resetYaw(resetYaw);

        // Telemetry
        telemetry.addData("Elapsed Time", runtime.seconds());
        telemetry.update();
    }
}
