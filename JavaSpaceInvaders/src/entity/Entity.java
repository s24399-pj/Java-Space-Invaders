package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {

    public int x;
    public int y;
    public int speed;

    public BufferedImage mainPhoto;

    public void getPlayerImage(String location){
        try{
            mainPhoto= ImageIO.read(getClass().getResourceAsStream(location));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
