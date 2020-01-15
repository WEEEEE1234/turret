package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TurretMovement {

    DcMotor leftYRot;
    DcMotor rightYRot;
    DcMotor zRot;

    

    public TurretMovement (HardwareMap turretMap) {
        leftYRot = turretMap.dcMotor.get("turretLYRot");
        rightYRot = turretMap.dcMotor.get("turretRYRot");
        zRot = turretMap.dcMotor.get("turretZRot");
    }



}
