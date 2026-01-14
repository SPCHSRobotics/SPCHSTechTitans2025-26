package org.firstinspires.ftc.teamcode.TTCode.auto.threeBallAutos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.TTCode.auto.autonomousFunctions.MovementFunctions;
import org.firstinspires.ftc.teamcode.TTCode.auto.autonomousFunctions.ShootingFunctions;
import org.firstinspires.ftc.teamcode.TTCode.auto.autonomousFunctions.StatusFunctions;
import org.firstinspires.ftc.teamcode.TTCode.robotInit.Bot;

@Autonomous (name = "Cucumber Short Red")
public class ShortRed extends LinearOpMode {

    private final Bot bot = new Bot();
    private final ElapsedTime runtime = new ElapsedTime();

    private final ShootingFunctions shoot = new ShootingFunctions(this, bot, runtime);
    private final MovementFunctions move = new MovementFunctions(this, bot, runtime);
    private final StatusFunctions status = new StatusFunctions(this, bot, runtime);


    @Override
    public void runOpMode() {

        // init
        bot.initHardware(hardwareMap);
        bot.setMotors();

        bot.RUN_USING_ENCODERS();


        telemetry.addLine("Every day I am thankful for being given this opportunity to help my robotics team succeed. With that being said, I pray with your strength that this auto will work. In God's name we pray, Amen.");
        telemetry.update();


        waitForStart();

        // main path
        move.backward(2.2);
        shoot.shootOld();
        move.forward(0.4);
        move.strafeLeft(0.3);
        status.end();

        sleep(1000);
    }

}
