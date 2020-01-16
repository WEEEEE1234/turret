package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsys.TurretMovement;

@TeleOp(name = "TurretPositonsTest")
public class TurretPostionsTest extends OpMode {

    TurretMovement turretMovement;

    @Override
    public void init() {
        turretMovement = new TurretMovement(hardwareMap);
        turretMovement.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    @Override
    public void loop() {

        /*telemetry.addData("lY", turretMovement.getTurretMotorPositions()[0]);
        telemetry.addData("rY", turretMovement.getTurretMotorPositions()[1]);
        telemetry.addData("z", turretMovement.getTurretMotorPositions()[2]);*/

    }




}
