package org.firstinspires.ftc.teamcode.tests;

import android.service.quicksettings.Tile;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.lib.util.Toggler;
import org.firstinspires.ftc.teamcode.subsys.IMU;
import org.firstinspires.ftc.teamcode.subsys.TileRunner;


/**
 * Created by Amar2 on 10/21/2017.
 */
@TeleOp(name = "DrivetrainTest", group = "tests")
public class DrivetrainTest extends OpMode {

    TileRunner drivetrain;
    IMU imu;
    Toggler stateTog = new Toggler(3);
    String mode = "";
    double[] power = new double[2];
    Toggler powerTog = new Toggler(50);
    double currentVelocity = 0;
    double previousMaxVelocity = 0;
    double previousVelocity = 0;
    double currentAcceleration = 0;
    double previousMaxAcceleration = 0;
    double currentTime = 0;
    double lastTime = 0;

    @Override
    public void init() {
        drivetrain = new TileRunner(hardwareMap);
        imu = new IMU(hardwareMap);
        telemetry.log().add("mode (normal/scaled/step) switch : gamepad1-x");
        telemetry.log().add("orientation switch : gamepad1-a");

    }

    @Override
    public void loop() {
        stateTog.changeState(gamepad1.x);

        powerTog.changeState(gamepad1.dpad_up, gamepad1.dpad_down);

        if (stateTog.currentState() == 0){
            drivetrain.operateWithOrientation(gamepad1.left_stick_y, gamepad1.right_stick_y);
            mode = "Tank";
        } else if (stateTog.currentState() == 1){
            drivetrain.operateWithOrientationScaled(gamepad1.left_stick_y, gamepad1.right_stick_y);
            mode = " Tank Scaled";
        } else if (stateTog.currentState() == 2){
            if (gamepad1.a) {
                drivetrain.operateWithOrientation(powerTog.currentState() * 0.02, powerTog.currentState() * 0.02);
            } else {
                drivetrain.operate(0.0, 0.0);
            }
            mode = "Step";
        }


        telemetry.addData("Mode:", mode);
        telemetry.addData("Orientation:", drivetrain.getOrientation());
        telemetry.addData("LeftStickY:", gamepad1.left_stick_y);
        telemetry.addData("RightStickY:", gamepad1.right_stick_y);
        //telemetry.addData("Scaled L", drivetrain.getScaledPower(gamepad1.left_stick_y));
        //telemetry.addData("Scaled R", drivetrain.getScaledPower(gamepad1.right_stick_y));
        telemetry.addData("Power (step)", powerTog.currentState()*0.02);
    }
}