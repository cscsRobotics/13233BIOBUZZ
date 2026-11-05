package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
 
public abstract class CyberKnightsOpMode extends LinearOpMode {
    public DriveControls drive = new DriveControls(hardwareMap);
    public MotorConstructor motors = new MotorConstructor(hardwareMap);
    public IntakeControl intake = new IntakeControl(hardwareMap);
    public ShooterControls shooter = new ShooterControls();
    public TransportControls transport = new TransportControls();


    // Constructor
    public CyberKnightsOpMode() {
        // Create the utils classes
        transport.servoInit(motors.bottomTransportServo, motors.leftBottom, motors.flicker, motors.rightBottom);
        transport.motorInit(motors.transWheel);
        shooter.initAllMotors(motors.launchYaw, motors.flywheel);
    }
}
