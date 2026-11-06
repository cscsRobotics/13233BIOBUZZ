// Import libraries
package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Utils_13233.CyberKnightsOpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;



/*
    Current Gamepad Controls
        Gamepad1:
            LeftStick  = forward left right back
            RightStuck = turn left and right
 */


@TeleOp(name = "TeleOpMain", group = "Drive")
public class TeleOpMain extends CyberKnightsOpMode {
    // This function is executed when this Op Mode is selected from the Driver Station
    @Override
    public void runOpMode() {
        // initalize the utils classes
        initialize();

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
            telemetry.addData("Flywheel RPM: ", shooter.getFlyWheelSpeed(motors.flywheel));
            telemetry.addData("yaw", motors.launchYaw.getCurrentPosition());
            telemetry.update();

            //Add option to enable brakes when sharbell holds a
            drive.setDriveMotorZeroPowerBehavior(gamepad1.b);


            // Sets the power to the drive motors based on current gamepad inputs
            drive.setPower(gamepad1.left_stick_y, gamepad1.left_stick_x,
                    gamepad1.right_stick_x, gamepad1.left_trigger);


            // runs the intake based on these settings
            intake.toggle(gamepad1.a, gamepad1.x);

            transport.run(gamepad1.dpad_down, gamepad1.dpad_up);// runs transport servos/motor, hopefully fixed issue with dpadup
            // Hold X to run the flicker forward, hold Y to run it in reverse
            transport.setFlicker(gamepad1.left_bumper); // this needs to be updated with the code sharbell wrote

            // Shooter
            shooter.adjustYaw(shooter.getMoveAmount(gamepad2.left_stick_x), motors.launchYaw);// inop, need this working for saturday
            shooter.setVelocity(motors.flywheel, gamepad1.right_bumper);

            //shooter.setVelocity(motors.flywheel, gamepad1.right_bumper);

            //sleep(100);
        }
        // Do not place any drive code here outside the while loop (will fail inspection)
    }
}
