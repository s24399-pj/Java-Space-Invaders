package main;

import entity.Alien;
import entity.Bullet;
import entity.Player;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel implements Runnable{

    final int originalTileSize=16;
    final int scale=3;

    final int tileSize=originalTileSize*scale;
    final int maxScreenCol=16;
    final int maxScreenRow=12;
    public final int screenWidth=tileSize*maxScreenCol;
    public final int screenHeight=tileSize*maxScreenRow;

    Thread gameThread;

    KeyHandler keyHand=new KeyHandler();
    Player player=new Player(this,keyHand);
    Bullet bullet=new Bullet(this,keyHand);

    Alien alien=new Alien(this,keyHand);



    int FramesPerSecond=60;


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
        player.updater(screenWidth,screenHeight,tileSize,bullet);
        bullet.updater();
        colisionDetector(player,alien,bullet);
    }

    public void colisionDetector(Player p,Alien a,Bullet b){
        int alienmax_x=a.x+a.tileSize;
        int alienmin_x=a.x-a.tileSize;
        int alienmax_y=a.y+a.tileSize;
        int alienmin_y=a.y-a.tileSize;

        if(b.x>alienmin_x && b.x<alienmax_x && b.y>alienmin_y && b.y<alienmax_y){
            b.used=true;
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        alien.draw(g2);
        bullet.draw(g2);
        player.draw(g2,tileSize);

        g2.dispose();

    }


}
