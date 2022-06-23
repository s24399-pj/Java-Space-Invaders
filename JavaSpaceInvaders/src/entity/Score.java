package entity;

import main.KeyHandler;
import main.Screen;

import javax.swing.*;
import java.awt.*;

public class Score extends Entity{

    Screen gameScreen;
    KeyHandler keyHand;
    public int value;

    public Score(Screen gameScreen , KeyHandler keyHand){
        this.gameScreen=gameScreen;
        this.keyHand=keyHand;
        this.x=25;
        this.y=25;
        this.value=0;
    }

    public void draw(Graphics2D g2,int score){
        this.value=score;
        g2.drawString("Score: "+score,25,25);
    }
}
