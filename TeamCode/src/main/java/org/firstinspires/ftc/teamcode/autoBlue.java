package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Utils_13233.CyberKnightsOpMode;
@Autonomous(name = "autoBlue",group = "Auto")
public class autoBlue extends CyberKnightsOpMode {
    @Override
    public void runOpMode() {
        initialize();

        waitForStart();
        if (opModeIsActive()) {

            drive.setPower(-1.0f, 0.0f, 0.0f, 0.0f);//drive foward
            sleep(250);
            drive.setPower(0.0f,0.0f,0.0f,0.0f);//stops
            drive.setPower(0.0f, -1.0f, 0.0f, 0.0f);//strafes to parking zone
            sleep(250);
            drive.setPower(0.0f,0.0f,0.0f,0.0f);//stops
            drive.setPower(1.0f, 0.0f, 0.0f, 0.0f);//drive backward
            sleep(250);
            drive.setPower(0.0f,0.0f,0.0f,0.0f);//stops
        }
    }
}// extremely difficult code above, look at your own risk

