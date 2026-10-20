package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterControls {
    private final MotorConstructor motors;

    public ShooterControls(HardwareMap hardwareMap) {
        this.motors = new MotorConstructor(hardwareMap);
    }

    private void initSetToPositionMotor(DcMotor motor){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    private void initAllMotors(DcMotor motor1, DcMotor motor2){
        initSetToPositionMotor(motor1);

        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


}
