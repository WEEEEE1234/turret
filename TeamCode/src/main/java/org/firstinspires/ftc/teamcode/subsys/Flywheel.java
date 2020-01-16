package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.lib.util.Toggler;


/**
 * Flywheel subsystem class, for newer 2-wheel flywheel design
 */

public class Flywheel
{
    public DcMotor topFlywheel;
    public DcMotorSimple bottomFlywheel;
    public CRServo ballFeed;

    private static final double FLYWHEEL_POWER = 1.0;
    private static final double FEED_POWER = 0.9;

    private String flywheelMode;
    private String flywheelState;

    private Toggler flywheelToggle = new Toggler(2);

    public Flywheel(HardwareMap flyMap) {
        topFlywheel = flyMap.dcMotor.get("flyTop");
        bottomFlywheel = flyMap.get(DcMotorSimple.class, "flyBottom");
        ballFeed = flyMap.crservo.get("flyFeed");

        bottomFlywheel.setDirection(DcMotorSimple.Direction.REVERSE);

        /*topFlywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomFlywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/

        topFlywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

    }

    public void operate(double power){
        bottomFlywheel.setPower(power);
        topFlywheel.setPower(power);
    }

    public void operateToggle(boolean gamepadInputFlywheel, boolean gamepadInputFeed)
    {
        flywheelToggle.changeState(gamepadInputFlywheel);
        switch(flywheelToggle.currentState()) {
            case 0:
                flywheelState = "Flywheel Stopped";
                topFlywheel.setPower(0.0);
                bottomFlywheel.setPower(0.0);
                break;
            case 1:
                flywheelState = "Flywheel running";
                topFlywheel.setPower(FLYWHEEL_POWER);
                bottomFlywheel.setPower(FLYWHEEL_POWER);
                ballFeed.setPower(gamepadInputFeed ? FEED_POWER : 0.0);
                break;
        }
    }

    public String getFlywheelMode() {
        return flywheelMode;
    }

    public String getFlywheelState() {
        return flywheelState;
    }
}