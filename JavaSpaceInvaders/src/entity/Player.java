package entity;

import main.KeyHandler;
import main.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    Screen gameScreen;
    KeyHandler keyHand;
    public int score;

    public Player(Screen gameScreen , KeyHandler keyHand){
        this.gameScreen=gameScreen;
        this.keyHand=keyHand;

        setDefaultValues();
        getPlayerImage("/images/ship.png");
    }

    public void setDefaultValues(){
        this.x=200;
        this.y=450;
        this.speed=2;
        this.score=0;
        this.healthLevel=100;
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
            bullet.setToCertainPlace(x+20,y);
        }
    }

    public void draw(Graphics2D g2,int tileSize){
        g2.drawImage(mainPhoto,x,y,tileSize,tileSize,null);
    }

}
