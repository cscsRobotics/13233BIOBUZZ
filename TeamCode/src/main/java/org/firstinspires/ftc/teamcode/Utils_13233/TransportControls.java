package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class TransportControls {
    public CRServo bottomTransportServo; // 0
    public CRServo transportServoLeftBottom; // 2
    public Servo flicker; // 1
    public CRServo transportServoRightBottom; // 3

    public DcMotor transWheel;

    public void servoInit(CRServo bottomTransportServoInput,
                          CRServo transportServoLeftBottomInput,
                          Servo flickerInput,
                          CRServo transportServoRightBottomInput) {
        bottomTransportServo = bottomTransportServoInput;
        transportServoLeftBottom = transportServoLeftBottomInput;
        flicker = flickerInput;
        transportServoRightBottom = transportServoRightBottomInput;
    }

    public void motorInit(DcMotor transWheelInput) {
        transWheel = transWheelInput;
    }

    public void setFlicker(boolean forward, boolean reverse) { // added by jacob 11/4/26
        if (forward) {
            flicker.setPosition(1.0);
        } else if (reverse) {
            flicker.setPosition(-1.0);
        } else {
            flicker.setPosition(0.0);
        }
    }

    public void setPower(float power) {
        bottomTransportServo.setPower(power);
        transportServoLeftBottom.setPower(power);
        //flicker.setPower(power);
        transportServoRightBottom.setPower(power);
        transWheel.setPower(power);

    }

    public void setPower(DcMotorSimple.Direction direction, float power) {
        switch (direction) {
            case FORWARD:
                bottomTransportServo.setPower(power);
                transportServoLeftBottom.setPower(power);
                //flicker.setPower(power);
                transportServoRightBottom.setPower(power);
                transWheel.setPower(power);
                break;
            case REVERSE:
                bottomTransportServo.setPower(-power);
                transportServoLeftBottom.setPower(-power);
                //flicker.setPower(-power);
                transportServoRightBottom.setPower(-power);
                transWheel.setPower(-power);
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
                bottomTransportServo.setPower(motorPower);
                transportServoLeftBottom.setPower(motorPower);
                // flicker.setPower(motorPower);
                transportServoRightBottom.setPower(motorPower);
                transWheel.setPower(motorPower);
                break;
            case REVERSE:
                bottomTransportServo.setPower(-motorPower);
                transportServoLeftBottom.setPower(-motorPower);
                // flicker.setPower(-motorPower);
                transportServoRightBottom.setPower(-motorPower);
                transWheel.setPower(-motorPower);
                break;
        }
    }
}