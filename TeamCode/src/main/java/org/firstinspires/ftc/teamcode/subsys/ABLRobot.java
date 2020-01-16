package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.tests.DrivetrainTest;

public class ABLRobot {

    public TileRunner drivetrain;
    public Flywheel flywheel;
    public TurretMovement turretMovement;

    public ABLRobot(HardwareMap hardwareMap){
        drivetrain = new TileRunner(hardwareMap);
        flywheel = new Flywheel(hardwareMap);
        turretMovement = new TurretMovement(hardwareMap);
    }


}
