
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

    KeyHandler keyHand=new KeyHandler();

    int FramesPerSecond=60;

    int playerPositionX=100;
    int playerPositionY=100;
    int playerSpeed=4;

    public Screen(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHand);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double gameDrawInterval=1000000000/FramesPerSecond;
        double gameNextDrawTime=System.nanoTime()+gameDrawInterval;

        while(gameThread!=null){
            updater();
            repaint();

            try {
                double remainingTime=gameNextDrawTime-System.nanoTime();
                remainingTime=remainingTime/1000000;
                
                if(remainingTime<0){
                    remainingTime=0;
                }

                Thread.sleep((long) remainingTime);

                gameNextDrawTime+=gameDrawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void updater(){
        if (keyHand.upActivated==true) {
            playerPositionY-=playerSpeed;
        }
        else if (keyHand.downActivated==true){
            playerPositionY+=playerSpeed;
        }
        else if (keyHand.leftActivated==true){
            playerPositionX-=playerSpeed;
        }
        else if (keyHand.rightActivated==true){
            playerPositionX+=playerSpeed;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerPositionX,playerPositionY,tileSize,tileSize);

        g2.dispose();

    }


}
