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

    public void initialize() {
        motors = new MotorConstructor(hardwareMap);
        drive = new DriveControls(hardwareMap);
        intake = new IntakeControl();
        shooter = new ShooterControls();
        transport = new TransportControls();

        transport.servoInit(motors.bottomTransportServo, motors.leftBottom, motors.flicker, motors.rightBottom);
        transport.motorInit(motors.transWheel);
        shooter.initAllMotors(motors.launchYaw, motors.flywheel);
        shooter.initServos(motors.hood);
        intake.motorInit(motors.intake);
    }

    public boolean triggerToBoolean(float trigger) {
        return trigger > 0.1;
    }

    public void runTransportAndShooter(boolean input) {
        shooter.setVelocity(motors.flywheel, input);
        transport.run(false, input);
    }
}
