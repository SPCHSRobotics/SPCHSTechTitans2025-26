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
        //robotFunctions.moveForward(0.2);
        //robotFunctions.turnLeft(0.12);
        robotFunctions.shoot();

        //robotFunctions.end();
        sleep(1000);


    }
}
