package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeControl {
    private final MotorConstructor motors;

    public IntakeControl(HardwareMap hardwareMap) {
        this.motors = new MotorConstructor(hardwareMap);
    }

    public void run(boolean isIntake) {
        if (isIntake) {
            motors.intake.setPower(1);
        } else {
            motors.intake.setPower(0);
        }
    }

}
