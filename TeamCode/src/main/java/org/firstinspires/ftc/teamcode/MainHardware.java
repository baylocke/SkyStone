package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
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
    DcMotor liftL = null;
    DcMotor liftR = null;
    Servo grabberFront = null;
    //ColorSensor colorSensor = null;
    RobotGyro gyro = null;
    //Servo grabberSideR = null;
    //Servo grabberSideL = null;


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
        liftL = hwMap.get(DcMotor.class, "liftL");
        liftR = hwMap.get(DcMotor.class, "liftR");
        grabberFront = hwMap.get(Servo.class,"grabberFront");
        //colorSensor = hwMap.get(ColorSensor.class, "colorSensor");
        gyro = new RobotGyro(hwMap);
        //grabberSideR = hwMap.get(Servo.class,"grabberSideR");
        //grabberSideL = hwMap.get(Servo.class,"grabberSideL");


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
        driveRearL.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
        driveRearR.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
    }
    public void drive360(double x, double y, double turn) {
        driveRearR.setPower(y + x - 2*turn);
        driveFrontR.setPower(y - x - 2*turn);
        driveRearL.setPower(y - x + 2*turn);
        driveFrontL.setPower(y + x + 2*turn);
    }

    public int RGBtoHSV(int rVal, int gVal, int bVal){
        int r = rVal/255;
        int g = gVal/255;
        int b = bVal/255;

        int cMin = Math.min(Math.min(r,g) ,b);
        int cMax = Math.max(Math.max(r,g) ,b);
        int diff = cMax-cMin;

        if (diff == 0)
            return 0;

        else if (cMax == r){
            return (60*((g-b)/diff)+360) % 360;
        }

        else if (cMax == g){
            return (60*((b-r)/diff)+120) % 360;
        }

        else if (cMax == b){
            return (60*((r-g)/diff)+240) % 360;
        }
        else
            return -1;
    }

  //  public boolean isYellow(){
       // int value = RGBtoHSV(colorSensor.red(),colorSensor.green(),colorSensor.blue());
        //return (50 < value && value <130);
  //w  }

    public void strafeInR(double numInches){
        double ticPerInch40 = 19.8943682;
        driveFrontL.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
        driveFrontR.setTargetPosition(-(int) (ticPerInch40 * numInches + 0.5));
        driveRearL.setTargetPosition(-((int) (ticPerInch40 * numInches + 0.5)));
        driveRearR.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
    }

    public void strafeInL(double numInches){
        double ticPerInch40 = 19.8943682;
        driveFrontL.setTargetPosition(-((int) (ticPerInch40 * numInches + 0.5)));
        driveFrontR.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
        driveRearL.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
        driveRearR.setTargetPosition(-((int) (ticPerInch40 * numInches + 0.5)));
    }

    public void turn (double power) {
        driveFrontR.setPower(-power);
        driveFrontL.setPower(power);
        driveRearR.setPower(-power);
        driveRearL.setPower(power);
    }

    public void turnDegrees (int degrees){
        double originalAngle = gyro.imu.getAngularOrientation().firstAngle;
        double deltaAngle = 0.0;
        double targetAngle = originalAngle + degrees;

        double angleAdd = 0.0;
        double lastAngle = originalAngle;

        if (degrees > 0){
            while (degrees < deltaAngle){

                if(deltaAngle < -1){
                    angleAdd = 360;
                }

                deltaAngle = gyro.imu.getAngularOrientation().firstAngle - originalAngle + angleAdd;

                turn(-.6*2*(degrees-deltaAngle)/degrees);
                lastAngle = gyro.imu.getAngularOrientation().firstAngle;
            }
        }

        else if (degrees < 0){
            while (degrees>deltaAngle){

                if (deltaAngle > 1){
                    angleAdd = 360;
                }

                deltaAngle = gyro.imu.getAngularOrientation().firstAngle - originalAngle - angleAdd;

                turn(.6*2*(degrees-deltaAngle)/degrees);
                lastAngle = gyro.imu.getAngularOrientation().firstAngle;
            }
        }

        turn(0);
    }




}