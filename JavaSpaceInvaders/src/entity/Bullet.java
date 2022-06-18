package entity;

import main.KeyHandler;
import main.Screen;

import java.awt.*;

public class Bullet extends Entity{
    Screen gameScreen;
    KeyHandler keyHand;
    public final int bulletSize=20;
    public boolean used=false;


    public Bullet(Screen gameScreen , KeyHandler keyHand){
        this.gameScreen=gameScreen;
        this.keyHand=keyHand;
        startingValues();
    }

    public void startingValues(){
        this.x=1000;
        this.y=2000;
        this.speed=6;
    }

    public void setToCertainPlace(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void getFromBoard(){
        x=1000;
        y=1000;
    }

    public void updater(){
        if(!used){
            y-=speed;
        }
        else{
            getFromBoard();
            this.used=false;
        }
    }


    public void draw(Graphics2D g2){
        g2.setColor(Color.yellow);
        g2.fillRect(x,y,bulletSize,bulletSize);
    }
}
