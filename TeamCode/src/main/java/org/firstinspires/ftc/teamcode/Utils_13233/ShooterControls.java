package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterControls {
    int yawTargetPos;
    int yawMin; // modify value
    int yawMax; // modify value

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
        return (int) (controllerInput * 100) / 10; // cast the input from a controller to an int
    }

    public double getFlyWheelSpeed(DcMotorEx flywheel) {
        // 20:1 (not exact) gear tick x 28 counts per revolution = 560 counter per revolution
        // (Flywheel tick per second / 560) = rps * 60 = rpm
        return (flywheel.getVelocity() / 560) * 60;
    }

    public void adjustYaw(int input, DcMotor motor) {
        // resets each time the function is called
        yawTargetPos = yawTargetPos + input;

        // deal with min and max
        if (yawTargetPos > yawMax) yawTargetPos = yawMin;
        else if (yawTargetPos < yawMin) yawTargetPos = yawMax;

        motor.setTargetPosition(yawTargetPos);
    }
}
