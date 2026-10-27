package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class TransportControls {
    public CRServo transportServoLeftTop;
    public CRServo transportServoLeftBottom;
    public CRServo transportServoRightTop;
    public CRServo transportServoRightBottom;

    public void servoInit(CRServo transportServoLeftTopInput,
                          CRServo transportServoLeftBottomInput,
                          CRServo transportServoRightTopInput,
                          CRServo transportServoRightBottomInput) {
        transportServoLeftTop = transportServoLeftTopInput;
        transportServoLeftBottom = transportServoLeftBottomInput;
        transportServoRightTop = transportServoRightTopInput;
        transportServoRightBottom = transportServoRightBottomInput;
    }

    public void setPower(float power) {
        transportServoLeftTop.setPower(power);
        transportServoLeftBottom.setPower(power);
        transportServoRightTop.setPower(power);
        transportServoRightBottom.setPower(power);

    }

    public void setPower(DcMotorSimple.Direction direction, float power) {
        switch (direction) {
            case FORWARD:
                transportServoLeftTop.setPower(power);
                transportServoLeftBottom.setPower(power);
                transportServoRightTop.setPower(power);
                transportServoRightBottom.setPower(power);
                break;
            case REVERSE:
                transportServoLeftTop.setPower(-power);
                transportServoLeftBottom.setPower(-power);
                transportServoRightTop.setPower(-power);
                transportServoRightBottom.setPower(-power);
                break;
        }
    }

    public void setPower(DcMotorSimple.Direction direction, boolean power) {
        float motorPower;

        if (power) {
            motorPower = 1.0f;
        } else {
            motorPower = 0.0f;
        }

        switch (direction) {
            case FORWARD:
                transportServoLeftTop.setPower(motorPower);
                transportServoLeftBottom.setPower(motorPower);
                transportServoRightTop.setPower(motorPower);
                transportServoRightBottom.setPower(motorPower);
                break;
            case REVERSE:
                transportServoLeftTop.setPower(-motorPower);
                transportServoLeftBottom.setPower(-motorPower);
                transportServoRightTop.setPower(-motorPower);
                transportServoRightBottom.setPower(-motorPower);
                break;
        }
    }
}
