package entity;

import main.KeyHandler;
import main.Screen;

import java.awt.*;

public class Bullet extends Entity{
    Screen gameScreen;
    KeyHandler keyHand;
    public final int bulletSizeWidth=5;
    public final int bulletSizeHeight=10;
    public boolean used;
    public int bullet_level;
    public int damage;


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
        this.damage=10;
        this.used=false;
    }

    public void setToCertainPlace(int x,int y){
        if(this.speed==0 || this.y<0){
            this.x=x;
            this.y=y;
            this.speed=bullet_level+3;
        }
    }

    public void levelUpUserGun(){
        this.bullet_level+=3;
        this.damage+=10;
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
        g2.fillRect(x,y,bulletSizeWidth,bulletSizeHeight);
    }
}
