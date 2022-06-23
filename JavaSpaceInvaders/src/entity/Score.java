package entity;

import main.KeyHandler;
import main.Screen;

import java.awt.*;

public class Score{

    Screen gameScreen;
    KeyHandler keyHand;
    public int x;
    public int y;

    public Score(Screen gameScreen , KeyHandler keyHand){
        this.gameScreen=gameScreen;
        this.keyHand=keyHand;
        this.setDefaultValues();
    }

    public void setDefaultValues(){
        this.x=10;
        this.y=20;
    }

    public void draw(Graphics2D g2,int score,int damage){
        g2.drawString("Score: "+score+"\nGun damage: "+damage,this.x,this.y);
    }
}
