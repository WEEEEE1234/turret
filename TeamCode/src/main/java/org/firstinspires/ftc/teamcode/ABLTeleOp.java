package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsys.ABLRobot;

@TeleOp(name = "ABLTele")
public class ABLTeleOp extends OpMode {

    ABLRobot robot;

    @Override
    public void init() {
        robot = new ABLRobot(hardwareMap);
    }

    @Override
    public void loop() {
        robot.drivetrain.operateArcade(gamepad1.left_stick_x, gamepad1.left_stick_y);
        robot.flywheel.operateToggle(gamepad1.right_bumper, gamepad1.right_trigger>0.01);
        robot.turretMovement.operate(-gamepad1.right_stick_y, gamepad1.right_stick_x);
    }
}
