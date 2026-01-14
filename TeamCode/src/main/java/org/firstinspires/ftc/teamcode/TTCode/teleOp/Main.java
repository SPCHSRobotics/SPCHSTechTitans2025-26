package org.firstinspires.ftc.teamcode.TTCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.TTCode.robotInit.Bot;
import org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions.Drive;
import org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions.Intake;
import org.firstinspires.ftc.teamcode.TTCode.teleOp.V3Functions.Shooter;

@TeleOp(name="THE Cucumber TeleOp")
public class Main extends OpMode {

    // Call Bot and Runtime in
    Bot bot = new Bot();
    ElapsedTime runtime = new ElapsedTime();

    // Call Function Classes In
    Intake intake =  new Intake(bot, runtime, telemetry);
    Shooter shooter = new Shooter(bot, runtime, telemetry);
    Drive drive = new Drive(bot, runtime, telemetry);


    @Override
    public void init() {
        bot.initHardware(hardwareMap);
        bot.setMotors();

        bot.RUN_WITHOUT_ENCODERS();

        telemetry.addLine("Don't lose this Andy");
        telemetry.update();
    }

    @Override
    public void loop() {
        // inputs

        // drivetrain
        double x, y, turn;
        x = -gamepad1.left_stick_x;
        y = -gamepad1.left_stick_y;
        turn = gamepad1.right_stick_x;

        // Intake/Shooters
        boolean intakeHold, shooterHold, outtakeHold;
        intakeHold = gamepad2.a;
        shooterHold = gamepad2.b;
        outtakeHold = gamepad2.x;

        // Functions
        intake.intake(intakeHold);
        intake.outtake(outtakeHold);
        shooter.shooter(shooterHold);
        drive.fieldCentricDrive(x, y, turn);

        // Telemetry
        telemetry.addData("Elapsed Time", runtime.seconds());
        telemetry.update();
    }
}
