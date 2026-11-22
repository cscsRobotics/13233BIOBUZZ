package org.firstinspires.ftc.teamcode.Utils_13233;

//import com.qualcomm.hardware.limelightvision.Limelight3A;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.IMU;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.VoltageSensor;

/**
 * Class holds motors and servos that are used throughout the code
 */
public class MotorConstructor {

    // Drive Motor
    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;

    //Intake Motor
    public DcMotor intake;

    //Shooter
    public DcMotorEx flywheel;
    public Servo hood;

    public DcMotor launchYaw; // yaw is rotation left to right
    //transport motors
    public DcMotor transWheel;

    //Transport Servos
    public Servo dozer;
    public CRServo bottomTransportServo;
    public CRServo leftBottom;
    public CRServo rightBottom;

    public MotorConstructor(HardwareMap hardwareMap) {
        // Map main Drive Motors
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        // Set direction of the main drive motors
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        // Intake
        intake = hardwareMap.get(DcMotor.class, "intake");
        //transport motor
        transWheel = hardwareMap.get(DcMotor.class, "transWheel");

        // Launcher
        flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        launchYaw = hardwareMap.get(DcMotor.class, "launchYaw");
        hood = hardwareMap.get(Servo.class, "hood");


        // Transport Servos should all be CR servos in order to let(BESIDES dozer)
        dozer = hardwareMap.get(Servo.class, "dozer");
        bottomTransportServo = hardwareMap.get(CRServo.class, "bottomTransportServo");
        rightBottom = hardwareMap.get(CRServo.class, "rightBottom");
        leftBottom = hardwareMap.get(CRServo.class, "leftBottom");
        //all transport servos obsolete. remove when its not a risk that ill destroy the code

        dozer.setDirection(Servo.Direction.REVERSE);//change name from flicker to dozer--flicker servo changed to dozer
        rightBottom.setDirection(CRServo.Direction.REVERSE);


    }
}
