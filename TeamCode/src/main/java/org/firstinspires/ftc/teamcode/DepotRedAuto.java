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

@Autonomous(name="DepotRedAuto", group="Iterative Opmode")
public class DepotRedAuto extends LinearOpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    MainHardware robot = new MainHardware();

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void runOpMode() {
        runtime.reset();
        robot.setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.colorSensor.enableLed(true);

        robot.driveInches(46.5);
        for (int i=0; i<5; i++) {
            if (robot.isYellow()) {
                robot.strafeInR(8);
            }
            else{
                robot.grabberFront.setPosition(1);
                sleep(2000);
                robot.driveInches(42 + (20-(8*i)));
                robot.grabberFront.setPosition(0);
                robot.driveInches((-(42 + (20-(8*i))))+8);
            }

        }

    }


}
