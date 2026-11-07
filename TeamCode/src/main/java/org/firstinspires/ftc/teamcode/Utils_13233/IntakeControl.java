package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeControl {
    DcMotor intake;

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
                reverseOn = false;   // can't run both directions at once
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
}