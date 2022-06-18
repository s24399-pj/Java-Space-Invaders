package entity;

import main.KeyHandler;
import main.Screen;

import java.awt.*;

public class Player extends Entity{
    Screen gameScreen;
    KeyHandler keyHand;

    public Player(Screen gameScreen , KeyHandler keyHand){
        this.gameScreen=gameScreen;
        this.keyHand=keyHand;

        setDefaultValues();
    }

    public void setDefaultValues(){
        x=100;
        y=100;
        speed=4;
    }

    public void updater(){
        if (keyHand.upActivated==true) {
            y-=speed;
        }
        else if (keyHand.downActivated==true){
            y+=speed;
        }
        else if (keyHand.leftActivated==true){
            x-=speed;
        }
        else if (keyHand.rightActivated==true){
            x+=speed;
        }
    }

    public void draw(Graphics2D g2,int tileSize){
        g2.setColor(Color.white);
        g2.fillRect(x,y,tileSize,tileSize);
    }

}
