package org.firstinspires.ftc.teamcode.TTCode.auto.threeBallAutos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.TTCode.robotInit.Bot;
import org.firstinspires.ftc.teamcode.TTCode.auto.autonomousFunctions.MovementFunctions;
import org.firstinspires.ftc.teamcode.TTCode.auto.autonomousFunctions.ShootingFunctions;
import org.firstinspires.ftc.teamcode.TTCode.auto.autonomousFunctions.StatusFunctions;

@Autonomous (name = "Cucumber Long Red")
public class LongRed extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();
    private final Bot robot = new Bot();

    private final MovementFunctions move = new MovementFunctions(this, robot, runtime);
    private final StatusFunctions status = new StatusFunctions(this, robot, runtime);
    private final ShootingFunctions shooter = new ShootingFunctions(this, robot, runtime);


    @Override
    public void runOpMode() {

        // init
        robot.initHardware(hardwareMap);
        robot.setMotors();

        robot.RUN_USING_ENCODERS();

        telemetry.addLine("Every day I am thankful for being given this opportunity to help my robotics team succeed. With that being said, I pray with your strength that this auto will work. In God's name we pray, Amen.");
        telemetry.update();

        waitForStart();

        // Main path
        move.forward(0.2);
        move.turnRight(0.1);
        shooter.shoot();
        move.turnLeft(0.08);
        move.strafeRight(0.5);

        status.end();
        sleep(1000);
    }
}
