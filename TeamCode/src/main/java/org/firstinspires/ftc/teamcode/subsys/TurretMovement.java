package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TurretMovement {

    DcMotor leftYRot;
    //DcMotor rightYRot;
    DcMotor zRot;

    double currentYRot = 0.0;
    double currentZRot = 0.0;

    int[] lastRotPositons = {0, 0, 0};

    // in degrees, min, max
    static final double[] Y_ROT_LIMITS = {-10.0, 13.0};
    static final double[] Z_ROT_LIMITS = {-10.0, 135.0};

    static final double DEGREES_PER_ENCODER_TICK_Y = 0.0;
    static final double DEGREES_PER_ENCODER_TICK_Z = 0.0;

    public TurretMovement (HardwareMap turretMap) {
        leftYRot = turretMap.dcMotor.get("turretLYRot");
//        rightYRot = turretMap.dcMotor.get("turretRYRot");
        zRot = turretMap.dcMotor.get("turretZRot");

        /*leftYRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightYRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        zRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);*/

//        rightYRot.setDirection(DcMotorSimple.Direction.REVERSE);

        lastRotPositons[0] = leftYRot.getCurrentPosition();
//        lastRotPositons[1] = rightYRot.getCurrentPosition();
        lastRotPositons[2] = zRot.getCurrentPosition();
    }


   /* public int[] getEncoderDeltas(){
        int[] encoderDeltas = new int[3];
        for(int i=0; i<lastRotPositons.length; i++){
            encoderDeltas[i] = getTurretMotorPositions()[i]-lastRotPositons[i];
            lastRotPositons[i] = getTurretMotorPositions()[i];
        }
        return encoderDeltas;
    }

    public void estimateYZRot(){

        int[] encoderDeltas = getEncoderDeltas();
        currentYRot += encoderDeltas[0]*DEGREES_PER_ENCODER_TICK_Y;
        currentZRot += encoderDeltas[2]*DEGREES_PER_ENCODER_TICK_Z;
    }*/

    public void operate(double gamepadInputY, double gamepadInputZ){

        leftYRot.setPower(gamepadInputY/0.25);
//        rightYRot.setPower(gamepadInputY);
        zRot.setPower(gamepadInputZ/0.25);

    }

    /*public int[] getTurretMotorPositions(){

        int[] turretMotorPositons = {leftYRot.getCurrentPosition(), rightYRot.getCurrentPosition(), zRot.getCurrentPosition()};
        return turretMotorPositons;
    }

    public void setMode(DcMotor.RunMode runMode){
        leftYRot.setMode(runMode);
        rightYRot.setMode(runMode);
        zRot.setMode(runMode);
    }*/

    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroPowerBehavior){
        leftYRot.setZeroPowerBehavior(zeroPowerBehavior);
        //rightYRot.setZeroPowerBehavior(zeroPowerBehavior);
        zRot.setZeroPowerBehavior(zeroPowerBehavior);
    }


}
