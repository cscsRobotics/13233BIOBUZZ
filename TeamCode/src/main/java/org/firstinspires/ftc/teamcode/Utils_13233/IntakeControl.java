package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeControl {
    DcMotor intake;
    Servo dozer;
    //toggle states
    private boolean forwardOn = false;
    private boolean reverseOn = false;
    private boolean lastForwardButton = false;
    private boolean lastReverseButton = false;

    public void motorInit(DcMotor inputIntake) {
        intake = inputIntake;
    }

    public void run(boolean isIntake) {
        if (isIntake) {
            intake.setPower(1);
        } else {
            intake.setPower(0);
        }
    }

    // toggle once for on, once for off
    public void toggle(boolean forwardButton, boolean reverseButton) {

        if (forwardButton && !lastForwardButton) {
            forwardOn = !forwardOn;
            if (forwardOn) {
                reverseOn = false;
            }
        }
        if (reverseButton && !lastReverseButton) {
            reverseOn = !reverseOn;
            if (reverseOn) {
                forwardOn = false;
            }
        }

        lastForwardButton = forwardButton;
        lastReverseButton = reverseButton;

        if (forwardOn) {
            intake.setPower(1.0);
        } else if (reverseOn) {
            intake.setPower(-1.0);
        } else {
            intake.setPower(0);
        }
    }
    public void servoInit(Servo inputDozer) {
        dozer = inputDozer;
    }
    public void setDozer(boolean isDozing) {//old flicker code
        double servoPos = isDozing ? 0.8 : 0.0;//PLACEHOLDERVALUES
        dozer.setPosition(servoPos);
    }
   // public void servoInit(Servo Dozerinput) {
   //     dozer = Dozerinput;
   //     dozer.setPosition(0.0);//default is up position (again, a guess on value fix later)
   // }
}