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

        motor.setTargetPosition(0);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motor.setPower(1);
    }

    public void initAllMotors(DcMotor yawMotor, DcMotor flywheel) {
        initSetToPositionMotor(yawMotor);

        //flywheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public int getMoveAmount(float controllerInput) {
        return (int) (controllerInput * 100) / 10; // cast the input from a controller to an int
    }

    public double getFlyWheelSpeed(DcMotorEx flywheel) {
        // Since the flywheel is a 1:1 motor it does not need to get convert its ticks back to base
        return (flywheel.getVelocity() / 28) * 60;
    }

    public void manualSetPower(DcMotorEx flywheel, float power) {
        flywheel.setPower(power);
    }

    public void manualSetPower(DcMotorEx flywheel, boolean power) {
        if (power) {
            flywheel.setPower(1.0);
        } else {
            flywheel.setPower(0.0);
        }
    }

    /**
     *
     * @param flywheel the motor you wish to use as the flywheel
     * @param power    the motor speed as a precent 0-100
     */
    public void setVelocity(DcMotorEx flywheel, double power) {
        flywheel.setVelocity(power * 60);
    }

    public void setVelocity(DcMotorEx flywheel, boolean isActive) {
        flywheel.setVelocity((isActive) ? 6000 : 0);
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
