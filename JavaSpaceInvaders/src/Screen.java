
import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel implements Runnable{

    final int originalTileSize=16;
    final int scale=3;

    final int tileSize=originalTileSize*scale;
    final int maxScreenCol=16;
    final int maxScreenRow=12;
    final int screenWidth=tileSize*maxScreenCol;
    final int screenHeight=tileSize*maxScreenRow;

    Thread gameThread;




    public Screen(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread!=null){
            System.out.println("Hello!");
        }
    }


}
