package org.firstinspires.ftc.teamcode.sandboxes.alexCode.alexAutos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous (name = "alexAuto long blue")
public class alexSorriestAutoLongBlue extends LinearOpMode {

    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        AutoTimeFunctions robotFunctions = new AutoTimeFunctions(hardwareMap);

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();

        // Autonomous procedure
        robotFunctions.moveForward(0.2);
        robotFunctions.turnLeft(0.1);
        robotFunctions.shoot();
        robotFunctions.turnRight(0.08);
        robotFunctions.strafeLeft(0.5);

        robotFunctions.end();
        sleep(1000);


    }
}
