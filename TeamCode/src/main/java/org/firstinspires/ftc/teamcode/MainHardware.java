package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MainHardware {
    DcMotor driveFrontR = null;
    DcMotor driveFrontL = null;
    DcMotor driveRearR = null;
    DcMotor driveRearL = null;
    DcMotor lift = null;
    Servo grabberFront = null;
    Servo grabberSideR = null;
    Servo grabberSideL = null;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public MainHardware(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        driveFrontR = hwMap.get(DcMotor.class,"driveFrontR");
        driveFrontR.setDirection(DcMotorSimple.Direction.REVERSE);
        driveFrontL = hwMap.get(DcMotor.class,"driveFrontL");
        driveRearR = hwMap.get(DcMotor.class,"driveRearR");
        driveRearR.setDirection(DcMotorSimple.Direction.REVERSE);
        driveRearL = hwMap.get(DcMotor.class,"driveRearL");
        lift = hwMap.get(DcMotor.class, "lift");
        grabberFront = hwMap.get(Servo.class,"grabberFront");
        grabberSideR = hwMap.get(Servo.class,"grabberSideR");
        grabberSideL = hwMap.get(Servo.class,"grabberSideL");
    }

    public void setDrivetrainMode(DcMotor.RunMode mode) {
        driveFrontR.setMode(mode);
        driveFrontL.setMode(mode);
        driveRearR.setMode(mode);
        driveRearL.setMode(mode);
    }

    public void driveInches(double numInches) {
        double ticPerInch40 = 19.8943682;
        driveFrontL.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
        driveFrontR.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
    }
    public void drive360(double x, double y, double turn){
        driveFrontR.setPower(y - x - 2*turn);
        driveFrontL.setPower(y + x + 2*turn);
        driveRearR.setPower(y + x - 2*turn);
        driveRearL.setPower(y - x + 2*turn);
    }
}