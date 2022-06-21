package entity;

import main.KeyHandler;
import main.Screen;

import java.awt.*;

public class Player extends Entity{
    Screen gameScreen;
    KeyHandler keyHand;

    public int score;

    public Player(Screen gameScreen , KeyHandler keyHand){
        this.gameScreen=gameScreen;
        this.keyHand=keyHand;

        setDefaultValues();
    }

    public void setDefaultValues(){
        x=100;
        y=100;
        speed=3;
    }

    public void updater(int screenWidth, int screenHeight, int tileSize,Bullet bullet){
        if (keyHand.upActivated) {
            if(y-speed>0){
                y-=speed;
            }
        }
        else if (keyHand.downActivated){
            if(y+speed<screenHeight-tileSize) {
                y += speed;
            }
        }
        else if (keyHand.leftActivated){
            if(x-speed>0) {
                x -= speed;
            }
        }
        else if (keyHand.rightActivated){
            if(x+speed<screenWidth-tileSize) {
                x += speed;
            }
        }
        else if(keyHand.spaceActivated){
            bullet.setToCertainPlace(x+10,y);
        }
    }

    public void draw(Graphics2D g2,int tileSize){
        g2.setColor(Color.white);
        g2.fillRect(x,y,tileSize,tileSize);
    }

}
