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

@Autonomous(name="DepotBlueAuto", group="Linear Opmode")
public class DepoBlueAuto extends LinearOpMode
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
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(1500);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.driveInches(32);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(2500);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        sleep(300);
        Color.RGBToHSV(robot.colorSensor.red() * 8, robot.colorSensor.green() * 8, robot.colorSensor.blue() * 8, hsvValues);
        if (hsvValues[0] < 10 || hsvValues[0] > 45) {
            robot.driveInchesMORE(-3);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(500);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.liftL.setPower(-.5);
            robot.liftR.setPower(-.5);
            sleep(1100);
            robot.liftL.setPower(0);
            robot.liftR.setPower(0);

            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.driveInchesMORE(4);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(500);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.grabberFront.setPosition(.85);
            sleep(500);

            robot.driveInchesMORE(-7);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(500);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.turnDegrees(98);
            sleep(300);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.driveInchesMORE(55);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(3000);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.grabberFront.setPosition(0);
            sleep(1000);

            robot.driveInchesMORE(-35);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(2500);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.turnDegrees(-95);
            sleep(300);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.driveInchesMORE(5);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(500);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.grabberFront.setPosition(.85);
            sleep(500);

            robot.driveInchesMORE(-10);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(1000);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.turnDegrees(95);
            sleep(300);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.driveInchesMORE(45);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(2500);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.grabberFront.setPosition(0);
            sleep(1000);

            robot.driveInchesMORE(-15);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(3000);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }

        else {
            /*robot.driveInchesMORE(-1);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(500);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); */

            robot.strafeInL(17);
            robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(1000);
            robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            sleep(500);
            Color.RGBToHSV(robot.colorSensor.red() * 8, robot.colorSensor.green() * 8, robot.colorSensor.blue() * 8, hsvValues);
            if (hsvValues[0] < 10 || hsvValues[0] > 45) {
                robot.driveInchesMORE(-3);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.liftL.setPower(-.5);
                robot.liftR.setPower(-.5);
                sleep(1100);
                robot.liftL.setPower(0);
                robot.liftR.setPower(0);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(4);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(400);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(.85);
                sleep(500);

                robot.driveInchesMORE(-7);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.turnDegrees(98);
                sleep(300);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(47);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(1800);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(0);
                sleep(500);

                robot.driveInchesMORE(-75);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(3000);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.turnDegrees(-95);
                sleep(300);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(7);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(.85);
                sleep(500);

                robot.driveInchesMORE(-11);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(800);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.turnDegrees(95);
                sleep(300);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(89);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(2250);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(0);
                sleep(500);

                robot.driveInchesMORE(-15);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(1000);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
            else{
                robot.driveInchesMORE(-1);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.strafeInL(10);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(2500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(-1);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.liftL.setPower(-.5);
                robot.liftR.setPower(-.5);
                sleep(1100);
                robot.liftL.setPower(0);
                robot.liftR.setPower(0);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(4);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(400);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(.85);
                sleep(500);

                robot.driveInchesMORE(-9);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.turnDegrees(98);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(43);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(2500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(0);
                sleep(500);

                robot.driveInchesMORE(-66);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(2700);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.turnDegrees(-95);
                sleep(300);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(9);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(.85);
                sleep(500);

                robot.driveInchesMORE(-4);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(350);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.turnDegrees(98);
                sleep(300);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.driveInchesMORE(65);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(2500);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                robot.grabberFront.setPosition(0);
                sleep(300);

                robot.driveInchesMORE(-15);
                robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
                sleep(1000);
                robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
        }

    }

}
