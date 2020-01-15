package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="zStoneBlueAutoONE", group="Linear Opmode")
public class StoneBlueAutoONE extends LinearOpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    MainHardware robot = new MainHardware();

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void runOpMode() {
        telemetry.addData("PLAYING", true);
        telemetry.update();

        robot.init(hardwareMap);
        runtime.reset();

        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        robot.colorSensor.enableLed(true);

        float hsvValues[] = {0F,0F,0F};

        final float values[] = hsvValues;
        Color.RGBToHSV(robot.colorSensor.red() * 8, robot.colorSensor.green() * 8, robot.colorSensor.blue() * 8, hsvValues);

        robot.liftL.setPower(.5);
        robot.liftR.setPower(.5);
        sleep(1000);
        robot.liftL.setPower(0);
        robot.liftR.setPower(0);

        robot.strafeInR(8);
        sleep(1500);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.driveInches(32);
        sleep(2500);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        sleep(300);
        Color.RGBToHSV(robot.colorSensor.red() * 8, robot.colorSensor.green() * 8, robot.colorSensor.blue() * 8, hsvValues);
        if (hsvValues[0] < 10 || hsvValues[0] > 45) {
            robot.driveInchesMORE(-3);
            sleep(500);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.liftL.setPower(-.5);
            robot.liftR.setPower(-.5);
            sleep(1100);
            robot.liftL.setPower(0);
            robot.liftR.setPower(0);

            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.driveInchesMORE(4);
            sleep(500);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.grabberFront.setPosition(.85);
            sleep(500);

            robot.liftL.setPower(.5);
            robot.liftR.setPower(.5);
            sleep(200);
            robot.liftL.setPower(0);
            robot.liftR.setPower(0);

            robot.driveInchesMORE(-50);
            sleep(4000);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.turnDegrees(98);
            sleep(300);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.driveInchesMORE(60);
            sleep(3000);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.grabberFront.setPosition(0);
            sleep(1000);

            robot.driveInchesMORE(-15);
            sleep(3000);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }

        else {

            robot.strafeInL(14);
            sleep(1000);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            sleep(500);
            Color.RGBToHSV(robot.colorSensor.red() * 8, robot.colorSensor.green() * 8, robot.colorSensor.blue() * 8, hsvValues);
            if (hsvValues[0] < 10 || hsvValues[0] > 45) {
                robot.driveInchesMORE(-3);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.liftL.setPower(-.5);
                robot.liftR.setPower(-.5);
                sleep(1100);
                robot.liftL.setPower(0);
                robot.liftR.setPower(0);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(4);
                sleep(400);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(.85);
                sleep(500);

                robot.liftL.setPower(.5);
                robot.liftR.setPower(.5);
                sleep(200);
                robot.liftL.setPower(0);
                robot.liftR.setPower(0);

                robot.driveInchesMORE(-50);
                sleep(4000);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.turnDegrees(98);
                sleep(300);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(55);
                sleep(1800);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(0);
                sleep(500);

                robot.driveInchesMORE(-15);
                sleep(1000);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
            else{
                robot.driveInchesMORE(-1);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.strafeInL(15);
                sleep(2500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(-3);
                sleep(900);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.liftL.setPower(-.5);
                robot.liftR.setPower(-.5);
                sleep(1100);
                robot.liftL.setPower(0);
                robot.liftR.setPower(0);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(4);
                sleep(400);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(.85);
                sleep(500);

                robot.liftL.setPower(.5);
                robot.liftR.setPower(.5);
                sleep(200);
                robot.liftL.setPower(0);
                robot.liftR.setPower(0);

                robot.driveInchesMORE(-50);
                sleep(4000);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.turnDegrees(98);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(50);
                sleep(2500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(0);
                sleep(500);

                robot.driveInchesMORE(-15);
                sleep(1000);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
        }

    }

}
