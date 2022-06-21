package entity;

import main.KeyHandler;
import main.Screen;

import java.awt.*;

public class Bullet extends Entity{
    Screen gameScreen;
    KeyHandler keyHand;
    public final int bulletSize=10;
    public boolean used;
    public int bullet_level;


    public Bullet(Screen gameScreen , KeyHandler keyHand){
        this.gameScreen=gameScreen;
        this.keyHand=keyHand;
        getFromBoard();
        startingValues();
    }

    public void startingValues(){
        this.x=-100;
        this.y=-100;
        this.speed=0;
        this.bullet_level=1;
        this.used=false;
    }

    public void setToCertainPlace(int x,int y){
        if(speed==0 || this.y<0){
            this.x=x;
            this.y=y;
            this.speed=2*bullet_level+3;
        }
    }

    public void levelUpUserGun(){
        this.bullet_level+=1;
    }

    public void getFromBoard(){
        this.x=-100;
        this.y=-100;
        this.speed=0;
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
