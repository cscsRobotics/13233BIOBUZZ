package org.firstinspires.ftc.teamcode.Utils_13233;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import org.firstinspires.ftc.robotcore.external.Telemetry;


public class ScreenControls {
    public void initScreen(){
        telemetry.setDisplayFormat(Telemetry.DisplayFormat.HTML);
    }
    String returnFormattedBall(ballType ball){
        switch(ball){
            case EMPTY:
                return("○");
            case POLLEN:
                return("<font color='#FFFF00'>●</font>");
            case NECTAR_RED:
                return("<font color='#FF0000'>●</font>");
            case NECTAR_BlUE:
                return("<font color='#0000FF'>●</font>");
            default:
                return("");
        }
    }
    String ballStringConstructor(ballType ball1, ballType ball2, ballType ball3, ballType ball4){
        return(returnFormattedBall(ball1) + " " + returnFormattedBall(ball2) +
                " " + returnFormattedBall(ball3)+ " " + returnFormattedBall(ball4));
    }
    public void printCurrentPollen(ballType ball1, ballType ball2, ballType ball3, ballType ball4){
        telemetry.addData("Balls", ballStringConstructor(ball1, ball2, ball3, ball4));
    }

    public enum ballType {
        EMPTY,
        NECTAR_RED,
        NECTAR_BlUE,
        POLLEN
    }
}
