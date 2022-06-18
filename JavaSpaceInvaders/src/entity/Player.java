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

    public void updater(int screenWidth, int screenHeight, int tileSize){
        if (keyHand.upActivated==true) {
            if(y-speed>0){
                y-=speed;
            }
        }
        else if (keyHand.downActivated==true){
            if(y+speed<screenHeight-tileSize) {
                y += speed;
            }
        }
        else if (keyHand.leftActivated==true){
            if(x-speed>0) {
                x -= speed;
            }
        }
        else if (keyHand.rightActivated==true){
            if(x+speed<screenWidth-tileSize) {
                x += speed;
            }
        }
    }

    public void draw(Graphics2D g2,int tileSize){
        g2.setColor(Color.white);
        g2.fillRect(x,y,tileSize,tileSize);
    }

}
