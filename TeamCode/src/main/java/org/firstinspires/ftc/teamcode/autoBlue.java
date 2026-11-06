package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Utils_13233.CyberKnightsOpMode;
@Autonomous(name = "autoBlue",group = "Auto")
public class autoBlue extends CyberKnightsOpMode {
    @Override
    public void runOpMode() {

        waitForStart();
        if (opModeIsActive()) {
            // forward/back = 0, strafe = STRAFE_POWER, turn = 0, brake trigger = 0
            drive.setPower(1.0f, 0.0f, 0.0f, 0.0f);//drive foward
            sleep(500);
            drive.setPower(0.0f,0.0f,0.0f,0.0f);//stops
            drive.setPower(0.0f, 1.0f, 0.0f, 0.0f);//strafes to parking zone
            sleep(1000);
            drive.setPower(0.0f,0.0f,0.0f,0.0f);//stops
            drive.setPower(-1.0f, 0.0f, 0.0f, 0.0f);//drive backward
            sleep(500);
            drive.setPower(0.0f,0.0f,0.0f,0.0f);//stops
        }
    }
}// extremely difficult code above, look at your own risk

