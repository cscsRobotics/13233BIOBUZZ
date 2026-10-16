package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class IntakeControl {
    private final MotorConstructor motors;
    public IntakeControl(HardwareMap hardwareMap) {
        this.motors = new MotorConstructor(hardwareMap);
    }

    public void runIntake(boolean isIntake){
        if(isIntake) {
            motors.intake.setPower(1);
        }
        else{
            motors.intake.setPower(0);
        }
    }

}
