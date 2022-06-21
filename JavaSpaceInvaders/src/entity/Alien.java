package entity;

import main.KeyHandler;
import main.Screen;

import java.awt.*;

public class Alien extends Entity{

    Screen gameScreen;
    KeyHandler keyHand;

    public int tileSize=40;
    public int alienLevel=1;


    public Alien(Screen gameScreen , KeyHandler keyHand,int x,int y){
        this.gameScreen=gameScreen;
        this.keyHand=keyHand;
        this.x=x;
        this.y=y;

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.blue);
        g2.fillRect(x,y,tileSize,tileSize);
    }

}
