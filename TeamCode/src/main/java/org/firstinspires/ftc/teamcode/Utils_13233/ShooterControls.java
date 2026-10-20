package org.firstinspires.ftc.teamcode.Utils_13233;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterControls {
    private final MotorConstructor motors;

    public ShooterControls(HardwareMap hardwareMap) {
        this.motors = new MotorConstructor(hardwareMap);
    }


}
