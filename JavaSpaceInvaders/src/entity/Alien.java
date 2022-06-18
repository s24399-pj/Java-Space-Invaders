package entity;

import main.KeyHandler;
import main.Screen;

import java.awt.*;

public class Alien extends Entity{

    Screen gameScreen;
    KeyHandler keyHand;

    public int tileSize=40;

    public Alien(Screen gameScreen , KeyHandler keyHand){
        this.gameScreen=gameScreen;
        this.keyHand=keyHand;
        setDefaultValues();
    }

    public void setDefaultValues(){
        x=200;
        y=50;
        speed=2;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.blue);
        g2.fillRect(x,y,tileSize,tileSize);
    }

}
