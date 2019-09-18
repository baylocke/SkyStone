package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MainHardware {
    DcMotor frDrvWheel = null;
    DcMotor flDrvWheel = null;
    DcMotor brDrvWheel = null;
    DcMotor blDrvWheel = null;
    Servo rGrabber = null;
    Servo lGrabber = null;


    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public MainHardware(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        frDrvWheel = hwMap.get(DcMotor.class,"frDrvWheel");
        frDrvWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        flDrvWheel = hwMap.get(DcMotor.class,"flDrvWheel");
        brDrvWheel = hwMap.get(DcMotor.class,"brDrvWheel");
        brDrvWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        blDrvWheel = hwMap.get(DcMotor.class,"blDrvWheel");
        rGrabber = hwMap.get(Servo.class,"rGrabber");
        lGrabber = hwMap.get(Servo.class,"lGrabber");
    }

    public void setDrivetrainMode(DcMotor.RunMode mode) {
        frDrvWheel.setMode(mode);
        flDrvWheel.setMode(mode);
    }

    public void driveInches(double numInches){
        double ticPerInch40 = 19.8943682;
        flDrvWheel.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
        frDrvWheel.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
    }


}

