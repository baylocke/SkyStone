package org.firstinspires.ftc.teamcode;

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

@Autonomous(name="BuildSiteBlueAuto", group="Linear Opmode")
public class BuildSiteBlueAuto extends LinearOpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    MainHardware robot = new MainHardware();

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        runtime.reset();

        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        robot.strafeInL(25);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(3000);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.driveInches(-10);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(3000);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.driveInches(32);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(4000);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.liftL.setPower(.5);
        robot.liftR.setPower(.5);
        sleep(1000);
        robot.liftL.setPower(0);
        robot.liftR.setPower(0);

        robot.driveInches(2);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(1000);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.liftL.setPower(-.5);
        robot.liftR.setPower(-.5);
        sleep(1100);
        robot.liftL.setPower(0);
        robot.liftR.setPower(0);

        robot.driveInches(-37);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(4000);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.liftL.setPower(.5);
        robot.liftR.setPower(.5);
        sleep(1000);
        robot.liftL.setPower(0);
        robot.liftR.setPower(0);

        robot.strafeInR(50);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(4000);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.turnDegrees(-95);
        sleep(2000);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.liftL.setPower(-.5);
        robot.liftR.setPower(-.5);
        sleep(1200);
        robot.liftL.setPower(0);
        robot.liftR.setPower(0);

        robot.driveInches(20);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(5000);
    }


}
