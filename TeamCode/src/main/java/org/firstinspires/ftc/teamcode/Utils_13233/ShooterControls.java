package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterControls {
    int yawTargetPos;
    int yawMin; // modify value
    int yawMax; // modify value

    private final MotorConstructor motors;

    public ShooterControls(HardwareMap hardwareMap) {
        this.motors = new MotorConstructor(hardwareMap);
    }

    private void initSetToPositionMotor(DcMotor motor) {
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motor.setTargetPosition(0);
        motor.setPower(1);
    }

    public void initAllMotors(DcMotor yawMotor, DcMotor flywheel) {
        initSetToPositionMotor(yawMotor);

        flywheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public int getMoveAmount(float controllerInput) {
        return (int) controllerInput; // cast the input from a controller to an int
    }

    public void adjustYaw(int input, DcMotor motor) {
        // resets each time the function is called
        int motorCurrentPosition = motor.getCurrentPosition();
        yawTargetPos = yawTargetPos + input;

        // deal with min and max
        if (yawTargetPos > yawMax) yawTargetPos = yawMin;
        else if (yawTargetPos < yawMin) yawTargetPos = yawMax;

        motor.setTargetPosition(yawTargetPos);
    }
}
