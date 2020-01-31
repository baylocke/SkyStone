package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class MainHardware {
    DcMotor driveFrontR = null;
    DcMotor driveFrontL = null;
    DcMotor driveRearR = null;
    DcMotor driveRearL = null;
    DcMotor liftL = null;
    DcMotor liftR = null;
    Servo grabberFront = null;
    ColorSensor colorSensor = null;
    RobotGyro gyro = null;
    Servo gripper = null;
    //Rev2mDistanceSensor distance = null;
    //DigitalChannel digitalTouch = null;
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
        driveFrontL = hwMap.get(DcMotor.class,"driveFrontL");
        driveRearR = hwMap.get(DcMotor.class,"driveRearR");
        //driveRearR.setDirection(DcMotorSimple.Direction.REVERSE);
        driveRearL = hwMap.get(DcMotor.class,"driveRearL");
        liftL = hwMap.get(DcMotor.class, "liftL");
        liftR = hwMap.get(DcMotor.class, "liftR");
        liftL.setDirection(DcMotorSimple.Direction.REVERSE);
        grabberFront = hwMap.get(Servo.class,"grabberFront");
        colorSensor = hwMap.get(ColorSensor.class, "colorSensor");
        gyro = new RobotGyro(hwMap);
        gripper = hwMap.get(Servo.class, "gripper");
        //grabberSideR = hwMap.get(Servo.class,"grabberSideR");
        //grabberSideL = hwMap.get(Servo.class,"grabberSideL");
        driveFrontL.setDirection(DcMotorSimple.Direction.REVERSE);
        driveRearL.setDirection(DcMotorSimple.Direction.REVERSE);
        //distance = hwMap.get(Rev2mDistanceSensor.class, "distance");
        //digitalTouch = hwMap.get(DigitalChannel .class, "sensor_digital");
    }

    public void setDrivetrainMode(DcMotor.RunMode mode) {
        this.driveFrontR.setMode(mode);
        this.driveFrontL.setMode(mode);
        this.driveRearR.setMode(mode);
        this.driveRearL.setMode(mode);
    }

    public void driveInches(double numInches) {
        double ticPerInch40 = 66.85;
        //double ticPerInch402 = 89.127;
        //double ticPerInch40 = 1.0;
        double inches = numInches;

        driveFrontL.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveFrontR.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveRearL.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveRearR.setTargetPosition((int) (ticPerInch40 * inches + 0.5));

        driveFrontL.setPower(.4);
        driveFrontR.setPower(.4);
        driveRearL.setPower(.4);
        driveRearR.setPower(.4);

        setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void driveInchesTry(double numInches) {
        setDrivetrainMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        double ticPerInch40 = 22.2816920329;
        //double ticPerInch402 = 89.127;
        //double ticPerInch40 = 1.0;

        double power = 0.0;
        double deltaInches = 0.0;

        while(driveFrontR.getCurrentPosition()/ticPerInch40 < numInches) {
            deltaInches = driveFrontR.getCurrentPosition()/ticPerInch40;
            //power = (.3*2*(numInches-deltaInches)/numInches)+.09;
            driveFrontL.setPower(.4);
            driveFrontR.setPower(.4);
            driveRearL.setPower(.4);
            driveRearR.setPower(.4);
        }

        driveFrontL.setPower(0);
        driveFrontR.setPower(0);
        driveRearL.setPower(0);
        driveRearR.setPower(0);

    }

    /* public void driveInchesDistance(double power, double d) {
        setDrivetrainMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        if (d > distance.getDistance(DistanceUnit.INCH)){
            while (d > distance.getDistance(DistanceUnit.INCH)) {
                driveFrontL.setPower(-power);
                driveFrontR.setPower(-power);
                driveRearL.setPower(-power);
                driveRearR.setPower(-power);
            }
        }
        else{
            while (d < distance.getDistance(DistanceUnit.INCH)) {
                driveFrontL.setPower(power);
                driveFrontR.setPower(power);
                driveRearL.setPower(power);
                driveRearR.setPower(power);
            }
        }

        driveFrontL.setPower(0);
        driveFrontR.setPower(0);
        driveRearL.setPower(0);
        driveRearR.setPower(0);
        setDrivetrainMode(DcMotor.RunMode.RUN_USING_ENCODER);
    } */

    public void driveInchesMORE(double numInches) {
        double ticPerInch40 = 66.85;
        //double ticPerInch402 = 89.127;
        //double ticPerInch40 = 1.0;
        double inches = numInches;

        driveFrontL.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveFrontR.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveRearL.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveRearR.setTargetPosition((int) (ticPerInch40 * inches + 0.5));

        driveFrontL.setPower(.9);
        driveFrontR.setPower(.9);
        driveRearL.setPower(.9);
        driveRearR.setPower(.9);

        setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void driveInchesMOREMORE(double numInches) {
        double ticPerInch40 = 66.85;
        //double ticPerInch402 = 89.127;
        //double ticPerInch40 = 1.0;
        double inches = numInches;

        driveFrontL.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveFrontR.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveRearL.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveRearR.setTargetPosition((int) (ticPerInch40 * inches + 0.5));

        driveFrontL.setPower(1);
        driveFrontR.setPower(1);
        driveRearL.setPower(1);
        driveRearR.setPower(1);

        setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void driveInchesLESS(double numInches) {
        double ticPerInch40 = 66.85;
        //double ticPerInch402 = 89.127;
        //double ticPerInch40 = 1.0;
        double inches = numInches;

        driveFrontL.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveFrontR.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveRearL.setTargetPosition((int) (ticPerInch40 * inches + 0.5));
        driveRearR.setTargetPosition((int) (ticPerInch40 * inches + 0.5));

        driveFrontL.setPower(.6);
        driveFrontR.setPower(.6);
        driveRearL.setPower(.6);
        driveRearR.setPower(.6);

        setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void drive360(double x, double y, double turn) {
        driveRearR.setPower(y + x - turn);
        driveFrontR.setPower(y - x - turn);
        driveRearL.setPower(y - x + turn);
        driveFrontL.setPower(y + x + turn);
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

    public boolean isYellow(){
        int value = RGBtoHSV(colorSensor.red(),colorSensor.green(),colorSensor.blue());
        return (50 < value && value <130);
    }

    public void strafeInR(double numInches){
        double ticPerInch40 = 66.845;
        driveFrontL.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
        driveFrontR.setTargetPosition(-(int) (ticPerInch40 * numInches + 0.5));
        driveRearL.setTargetPosition(-((int) (ticPerInch40 * numInches + 0.5)));
        driveRearR.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));

        driveFrontL.setPower(.4);
        driveFrontR.setPower(.4);
        driveRearL.setPower(.4);
        driveRearR.setPower(.4);

        setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void strafeInL(double numInches){
        double ticPerInch40 = 66.85;
        driveFrontL.setTargetPosition(-((int) (ticPerInch40 * numInches + 0.5)));
        driveFrontR.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
        driveRearL.setTargetPosition((int) (ticPerInch40 * numInches + 0.5));
        driveRearR.setTargetPosition(-((int) (ticPerInch40 * numInches + 0.5)));

        driveFrontL.setPower(.4);
        driveFrontR.setPower(.4);
        driveRearL.setPower(.4);
        driveRearR.setPower(.4);

        setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void turnDegrees (int degrees){
        double originalAngle = gyro.imu.getAngularOrientation().firstAngle;
        double deltaAngle = 0.0;
        double angleAdd = 0.0;

        double power = 1.0;

        if (degrees > 0){
            while (degrees > deltaAngle+10  && Math.abs(power)>.2){

                if(deltaAngle < -1){
                    angleAdd = 360;
                }

                deltaAngle = gyro.imu.getAngularOrientation().firstAngle - originalAngle + angleAdd;

                power = -.6*2*(degrees-deltaAngle)/degrees;

                turn(power);
            }
        }

        else if (degrees < 0){
            while (degrees < deltaAngle-10 && Math.abs(power)>.2){

                if (deltaAngle > 1){
                    angleAdd = 360;
                }

                deltaAngle = gyro.imu.getAngularOrientation().firstAngle - originalAngle - angleAdd;

                power = .6*2*(degrees-deltaAngle)/degrees;

                turn(power);
            }
        }

        turn(0);
        setDrivetrainMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void turnDegreesTWO (int degrees){
        double originalAngle = gyro.imu.getAngularOrientation().firstAngle;
        double deltaAngle = 0.0;
        double angleAdd = 0.0;

        if (degrees > 0){
            while (degrees > deltaAngle+3){

                if(deltaAngle < -1){
                    angleAdd = 360;
                }

                deltaAngle = gyro.imu.getAngularOrientation().firstAngle - originalAngle + angleAdd;

                turn((-.6*2*(degrees-deltaAngle)/degrees)-.09);
            }
        }

        else if (degrees < 0){
            while (degrees < deltaAngle-3){

                if (deltaAngle > 1){
                    angleAdd = 360;
                }

                deltaAngle = gyro.imu.getAngularOrientation().firstAngle - originalAngle - angleAdd;

                turn((.6*2*(degrees-deltaAngle)/degrees)+.09);
            }
        }

        turn(0);
        setDrivetrainMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void turn (double power) {
        setDrivetrainMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        driveFrontR.setPower(-power);
        driveFrontL.setPower(power);
        driveRearR.setPower(-power);
        driveRearL.setPower(power);

    }

    public void strafeTry (double power, double numInches){
        //POSITIVE POWER = RIGHT
        //NEGATIVE POWER = LEFT
        setDrivetrainMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        boolean check = false;
        if (power == Math.abs(power)){
            check = true;
        }

        double ticPerInch40 = 22.2816920329;
        double originalAngle = gyro.imu.getAngularOrientation().firstAngle;


        while(Math.abs(driveFrontL.getCurrentPosition())/50 < numInches) {
            if (gyro.imu.getAngularOrientation().firstAngle > originalAngle + 2){
                if(check){
                    driveFrontR.setPower(-power-.3);
                    driveFrontL.setPower(power);
                    driveRearR.setPower(power);
                    driveRearL.setPower(-power+.3);
                }
                else{
                    driveFrontR.setPower(-power-.3);
                    driveFrontL.setPower(power);
                    driveRearR.setPower(power);
                    driveRearL.setPower(-power+.3);
                }
            }
            else if (gyro.imu.getAngularOrientation().firstAngle < originalAngle - 2){
                if (check){
                    driveFrontR.setPower(-power+.3);
                    driveFrontL.setPower(power);
                    driveRearR.setPower(power);
                    driveRearL.setPower(-power-.3);
                }
                else{
                    driveFrontR.setPower(-power+.3);
                    driveFrontL.setPower(power);
                    driveRearR.setPower(power);
                    driveRearL.setPower(-power-.3);
                }
            }
            else{
                driveFrontR.setPower(-power);
                driveFrontL.setPower(power);
                driveRearR.setPower(power);
                driveRearL.setPower(-power);
            }

        }

        driveFrontR.setPower(0);
        driveFrontL.setPower(0);
        driveRearR.setPower(0);
        driveRearL.setPower(0);
        setDrivetrainMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void driveInchesTry2(double numInches) {
        setDrivetrainMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        double ticPerInch40 = 22.2816920329;
        //double ticPerInch402 = 89.127;
        //double ticPerInch40 = 1.0;

        double power = 0.0;
        double deltaInches = 0.0;

        while(driveFrontR.getCurrentPosition()/ticPerInch40 < numInches) {
            deltaInches = driveFrontR.getCurrentPosition()/ticPerInch40;
            //power = (.3*2*(numInches-deltaInches)/numInches)+.09;
            driveFrontL.setPower(.4);
            driveFrontR.setPower(.4);
            driveRearL.setPower(.4);
            driveRearR.setPower(.4);
        }

        driveFrontL.setPower(0);
        driveFrontR.setPower(0);
        driveRearL.setPower(0);
        driveRearR.setPower(0);
        setDrivetrainMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void straighten (double target){
        setDrivetrainMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (gyro.imu.getAngularOrientation().firstAngle > target + 2){
            driveFrontL.setPower(.2);
            driveFrontR.setPower(0);
            driveRearL.setPower(0);
            driveRearR.setPower(-.2);
        }
        while (gyro.imu.getAngularOrientation().firstAngle < target - 2){
            driveFrontL.setPower(-.2);
            driveFrontR.setPower(0);
            driveRearL.setPower(0);
            driveRearR.setPower(.2);
        }
        setDrivetrainMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


}