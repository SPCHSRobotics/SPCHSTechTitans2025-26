package org.firstinspires.ftc.teamcode.TTCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Disabled
public class ShooterTT {
    //left or right??
    DcMotor shooterMotor1;
    DcMotor shooterMotor2;

    public ShooterTT(HardwareMap hardwareMap) {
        shooterMotor1 = hardwareMap.get(DcMotor.class, "shooterMotor1");
        shooterMotor2 = hardwareMap.get(DcMotor.class, "shooterMotor2");
    }

    //u should probably say if you are using gamepad 1 or 2 here
    public void shooterTT(Gamepad gamepad, Telemetry telemetry) {
        while (gamepad.a) {
            shooterMotor1.setPower(1);
            shooterMotor2.setPower(-1);
        }
    }
}

