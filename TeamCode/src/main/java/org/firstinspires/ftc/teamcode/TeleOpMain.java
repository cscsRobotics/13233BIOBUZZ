// Import libraries
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.teamcode.Utils_13233.DriveControls;
import org.firstinspires.ftc.teamcode.Utils_13233.IntakeControl;
import org.firstinspires.ftc.teamcode.Utils_13233.MotorConstructor;
//import org.firstinspires.ftc.teamcode.Utils_13233.ScreenControls;
import org.firstinspires.ftc.teamcode.Utils_13233.ShooterControls;
import org.firstinspires.ftc.teamcode.Utils_13233.TransportControls;


/*
    Current Gamepad Controls
        Gamepad1:
            LeftStick  = forward left right back
            RightStuck = turn left and right
 */


@TeleOp(name = "TeleOpMain", group = "Drive")
public class TeleOpMain extends LinearOpMode {

    // Constructors for the utils classes
    //private ScreenControls screen;


    //This function is executed when this Op Mode is selected from the Driver Station
    @Override
    public void runOpMode() {
        // Create the utils classes
        DriveControls drive = new DriveControls(hardwareMap);
        MotorConstructor motors = new MotorConstructor(hardwareMap);
        IntakeControl intake = new IntakeControl(hardwareMap);
        ShooterControls shooter = new ShooterControls();
        TransportControls transport = new TransportControls();

        transport.servoInit(motors.bottomTransportServo, motors.leftBottom, motors.flicker, motors.rightBottom);
        transport.motorInit(motors.transWheel);
        shooter.initAllMotors(motors.launchYaw, motors.flywheel);

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
            telemetry.addData("Flywheel RPM: ", shooter.getFlyWheelSpeed(motors.flywheel));
            telemetry.update();

            //Add option to enable brakes when sharbell holds a
            drive.setDriveMotorZeroPowerBehavior(gamepad1.b);


            // Sets the power to the drive motors based on current gamepad inputs
            drive.setPower(gamepad1.left_stick_y, gamepad1.left_stick_x,
                    gamepad1.right_stick_x, gamepad1.left_trigger);


            // runs the intake based on these settings
            intake.run(gamepad1.a,gamepad1.x);

            transport.setPower(DcMotorSimple.Direction.FORWARD, gamepad1.dpad_up);//runs transport servos/motor
            transport.setPower(DcMotorSimple.Direction.REVERSE, gamepad1.dpad_down);
            // Hold X to run the flicker forward, hold Y to run it in reverse
            transport.setFlicker(gamepad1.left_bumper);
            // Shooter
            shooter.adjustYaw(shooter.getMoveAmount(gamepad2.left_stick_x), motors.launchYaw);

            shooter.setVelocity(motors.flywheel, gamepad1.right_bumper);

            //shooter.setVelocity(motors.flywheel, gamepad1.right_bumper);

            sleep(100);
        }
        // Do not place any drive code here outside the while loop (will fail inspection)
    }
}
