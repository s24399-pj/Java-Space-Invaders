package entity;

import main.KeyHandler;
import main.Screen;

import java.awt.*;

public class Alien extends Entity{

    Screen gameScreen;

    public int tileSizeHeight=30;
    public int tileSizeWidth=40;
    public boolean dead=false;


    public Alien(Screen gameScreen,int x,int y){
        this.gameScreen=gameScreen;
        this.x=x;
        this.y=y;

        setDefaultValues();
        getPlayerImage("/images/alien.png");
    }

    public void setDefaultValues(){
        this.healthLevel=20;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(mainPhoto,x,y,tileSizeWidth,tileSizeHeight,null);
    }

}
