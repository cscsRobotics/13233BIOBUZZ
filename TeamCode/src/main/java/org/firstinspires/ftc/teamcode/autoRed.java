package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Utils_13233.CyberKnightsOpMode;
@Autonomous(name = "autoRed",group = "Auto")
public class autoRed extends CyberKnightsOpMode {
    @Override
    public void runOpMode() {
        initialize();

        waitForStart();
        if (opModeIsActive()) {
            // forward/back = 0, strafe = STRAFE_POWER, turn = 0, brake trigger = 0
            drive.setPower(1.0f, 0.0f, 0.0f, 0.0f);//drive forward
            sleep(500);
            drive.setPower(0.0f,0.0f,0.0f,0.0f);//stops
            drive.setPower(0.0f, -1.0f, 0.0f, 0.0f);//strafes to parking zone
            sleep(1000);
            drive.setPower(0.0f,0.0f,0.0f,0.0f);//stops
            drive.setPower(-1.0f, 0.0f, 0.0f, 0.0f);//drive backward
            sleep(500);
            drive.setPower(0.0f,0.0f,0.0f,0.0f);//stops
        }
    }
}// yeah this is just a copy paste of autoBlue with 1 value changed im not gonna lie