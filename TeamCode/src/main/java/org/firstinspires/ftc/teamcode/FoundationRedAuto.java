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

@Autonomous(name="FundationRedAuto", group="Linear Opmode")
public class FoundationRedAuto extends LinearOpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    MainHardware robot = new MainHardware();
    double moveRight = 66.845*34;
    double MoveBack = 66.845*52;

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        runtime.reset();

        robot.init(hardwareMap);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.gripper.setPosition(1);
        sleep(2000);
        robot.driveFrontL.setTargetPosition((int)moveRight);
        robot.driveFrontR.setTargetPosition((int)-moveRight);
        robot.driveRearL.setTargetPosition((int)moveRight);
        robot.driveRearR.setTargetPosition((int)-moveRight);
        robot.driveFrontL.setPower(.5);
        robot.driveFrontR.setPower(-.5);
        robot.driveRearL.setPower(.5);
        robot.driveRearR.setPower(-.5);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(5000);
        robot.gripper.setPosition(0);
        sleep(2000);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.driveFrontL.setTargetPosition((int)-moveRight);
        robot.driveFrontR.setTargetPosition((int)moveRight);
        robot.driveRearL.setTargetPosition((int)-moveRight);
        robot.driveRearR.setTargetPosition((int)moveRight);
        robot.driveFrontL.setPower(-.5);
        robot.driveFrontR.setPower(.5);
        robot.driveRearL.setPower(-.5);
        robot.driveRearR.setPower(.5);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(5000);
        robot.gripper.setPosition(1);
        sleep(2000);
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.driveFrontL.setTargetPosition((int)-MoveBack);
        robot.driveFrontR.setTargetPosition((int)-MoveBack);
        robot.driveRearL.setTargetPosition((int)-MoveBack);
        robot.driveRearR.setTargetPosition((int)-MoveBack);
        robot.driveFrontL.setPower(-.5);
        robot.driveFrontR.setPower(-.5);
        robot.driveRearL.setPower(-.5);
        robot.driveRearR.setPower(-.5);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(5000);
    }


}
