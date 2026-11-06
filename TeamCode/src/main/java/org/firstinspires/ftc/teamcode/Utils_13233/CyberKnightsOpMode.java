package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class CyberKnightsOpMode extends LinearOpMode {
    public DriveControls drive;
    public MotorConstructor motors;
    public IntakeControl intake;
    public ShooterControls shooter;
    public TransportControls transport;

    // Constructor
    public CyberKnightsOpMode() {

    }

    public void initalize() {
        motors = new MotorConstructor(hardwareMap);
        drive = new DriveControls(hardwareMap);
        intake = new IntakeControl();
        shooter = new ShooterControls();
        transport = new TransportControls();

        transport.servoInit(motors.bottomTransportServo, motors.leftBottom, motors.flicker, motors.rightBottom);
        transport.motorInit(motors.transWheel);
        shooter.initAllMotors(motors.launchYaw, motors.flywheel);
        intake.motorInit(motors.intake);
    }
}
