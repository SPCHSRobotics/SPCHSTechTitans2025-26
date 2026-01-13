package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos.paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos.autonomousFunctions.ShootingFunctions;
import org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos.autonomousFunctions.StatusFunctions;
import org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos.autonomousFunctions.MovementFunctions;
import org.firstinspires.ftc.teamcode.sandboxes.alexCode.robotInit.Bot;

@Autonomous (name = "alexAuto long blue refactored")
public class alexAutoLongBlue1v2 extends LinearOpMode {

    final ElapsedTime runtime = new ElapsedTime();
    final Bot robot = new Bot();

    MovementFunctions move = new MovementFunctions(this, robot, runtime);
    StatusFunctions status = new StatusFunctions(this, robot, runtime);
    ShootingFunctions shooter = new ShootingFunctions(this, robot, runtime);

    @Override
    public void runOpMode() {

        // init
        robot.initHardware(hardwareMap);
        robot.setMotors();

        robot.RUN_USING_ENCODERS();

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();

        // Main path
        move.forward(0.2);
        move.turnLeft(0.1);
        shooter.shoot();
        move.turnRight(0.08);
        move.strafeLeft(0.5);

        status.end();
        sleep(1000);
    }
}
