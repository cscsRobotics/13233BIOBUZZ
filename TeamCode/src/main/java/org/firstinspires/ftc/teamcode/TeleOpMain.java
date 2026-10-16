// Import libraries
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Utils_13233.DriveControls;
import org.firstinspires.ftc.teamcode.Utils_13233.IntakeControl;
import org.firstinspires.ftc.teamcode.Utils_13233.MotorConstructor;
import org.firstinspires.ftc.teamcode.Utils_13233.ScreenControls;

/*
    Current Gamepad Controls
        Gamepad1:
            LeftStick  = forward left right back
            RightStuck = turn left and right
 */


@TeleOp(name = "TeleOpMain", group = "Drive")
public class TeleOpMain extends LinearOpMode {

    // Constructors for the utils classes
    private DriveControls drive;
    private IntakeControl intake;
    private MotorConstructor motors;
    private ScreenControls screen;


    //This function is executed when this Op Mode is selected from the Driver Station
    @Override
    public void runOpMode() {
        // Create the utils classes
        drive = new DriveControls(hardwareMap);
        motors = new MotorConstructor(hardwareMap);
        intake = new IntakeControl(hardwareMap);

        // init the telemetry screen
        //screen.initScreen();

        // Wait for the game to start (driver presses PLAY)
        // The waitForStart() function will wait for the start button to begin
        // DON'T WRITE ANY CODE AFTER THE WAIT FOR START UNTIL THE "while (opModIsActive())"
        // THIS WILL CAUSE PROBLEMS WHEN GOING THROUGH INSPECTION
        waitForStart();
        // Run code while op mode is active
        while (opModeIsActive()) {
            // Add status data to driver hub display
            telemetry.addData("Status", "opModeIsActive");
            telemetry.addLine();
            // Print the telemetry to the screen
            // TODO: Actually give this live information
//            screen.printCurrentPollen(ScreenControls.ballType.POLLEN,
//                    ScreenControls.ballType.NECTAR_RED, ScreenControls.ballType.NECTAR_BlUE,
//                    ScreenControls.ballType.EMPTY);
            telemetry.update();


            sleep(50);

            //Add option to enable brakes when sharbell holds a
            drive.setDriveMotorZeroPowerBehavior(gamepad1.b);

            // Sets the power to the drive motors based on current gamepad inputs
            drive.setDrivePower(gamepad1.left_stick_y, gamepad1.left_stick_x,
                gamepad1.right_stick_x, gamepad1.left_trigger);

            intake.runIntake(gamepad1.a);

            // Slow down the loop because for some reason it goes to fast and causes the motors to
            // not work properly
            sleep(50);
        }
        // Do not place any drive code here outside of the while loop (will fail inspection)
    }
}
