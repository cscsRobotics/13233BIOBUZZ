package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.CRServo;

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
}
