// Import libraries
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Utils_13233.DriveControls;
import org.firstinspires.ftc.teamcode.Utils_13233.MotorConstructor;

/*
    Current Controls:
    Gamepad1:
        Left  Stick Y: Forward backward movement
        Left  Stick X: Left right strafe movement
        Right Stick X: Turn the entier robot left and right

        A:   Move the flipper to push the artifact
        B:   Set the drive motors to brake
        X:   Set launch wheels to 0.7 power
        Left Bumper: Set launch wheels to 1.0 power

    Gamepad2:
        D-Pad:
            Left:  Move sorter to launch position 1
            Up:    Move sorter to launch position 2
            Right: Move sorter to launch position 3

        X: Move sorter to intake position 1
        Y: Move sorter to intake position 2
        B: Move sorter to intake position 3

 */


@TeleOp(name = "TeleOpMain", group = "Drive")
public class TeleOpMain extends LinearOpMode {

    // Constructors for the utils classes
    private DriveControls drive;
    private MotorConstructor motors;


    //This function is executed when this Op Mode is selected from the Driver Station
    @Override
    public void runOpMode() {
        // Create the utils classes
        drive = new DriveControls(hardwareMap);
        motors = new MotorConstructor(hardwareMap);

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
            telemetry.addData("Sorter ", "Stats");
            telemetry.update();
            sleep(50);

            //Add option to enable brakes when sharbell holds a
            drive.setDriveMotorZeroPowerBehavior(gamepad1.b);

            // Sets the power to the drive motors based on current gamepad inputs
            drive.setDrivePower(gamepad1.left_stick_y, gamepad1.left_stick_x,
                gamepad1.right_stick_x, gamepad1.left_trigger);

            // Slow down the loop because for some reason it goes to fast and causes the motors to
            // not work properly
            sleep(50);
        }
        // Do not place any drive code here outside of the while loop (will fail inspection)
    }
}
