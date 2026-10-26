package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.VoltageSensor;

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

<<<<<<< Updated upstream
    //Shooter
    public DcMotorEx flywheel;
    public DcMotor launchYaw; // yaw is rotation left to right
=======
    //Servos
    public CRServo rightTop;
    public CRServo leftTop;
    public CRServo leftBottom;
    public CRServo rightBottom;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream

        // Launcher
        flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        launchYaw = hardwareMap.get(DcMotor.class, "launchYaw");
=======
        //Servos
        rightTop = hardwareMap.get(CRServo.class, "rightTop");
        leftTop = hardwareMap.get(CRServo.class,"leftTop");
        rightBottom = hardwareMap.get(CRServo.class, "rightBottom");
        leftBottom = hardwareMap.get(CRServo.class, "leftBottom");

>>>>>>> Stashed changes
    }
}
