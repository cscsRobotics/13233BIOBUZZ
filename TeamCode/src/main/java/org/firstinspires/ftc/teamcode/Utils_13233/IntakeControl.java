package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeControl {
    DcMotor intake;

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

}
