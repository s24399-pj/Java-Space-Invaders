package main;

import entity.Alien;
import entity.Bullet;
import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Alien> alienList=new ArrayList<>();

    void populateAlienList(){
        int cordX=30;
        int cordY=25;
        for (int j=0;j < alien_column;j++) {
            for (int i = 0; i < alien_row; i++) {
                alienList.add(i, new Alien(this, keyHand, cordX, cordY));
                cordX += 75;
            }
            cordY += 75;
            cordX=30;
        }
    }

    Player player=new Player(this,keyHand);
    Bullet bullet=new Bullet(this,keyHand);

    int alien_row=10;
    int alien_column=3;

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

        populateAlienList();

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

        for (int i = 0; i < alien_row*alien_column; i++){
            colisionDetector(player,alienList.get(i),bullet);
        }

    }



    public void colisionDetector(Player p,Alien a,Bullet b){
        int alienmax_x=a.x+a.tileSizeWidth;
        int alienmin_x=a.x-a.tileSizeWidth;
        int alienmax_y=a.y+a.tileSizeHeight;
        int alienmin_y=a.y-a.tileSizeHeight;

        if(b.x>alienmin_x && b.x<alienmax_x && b.y>alienmin_y && b.y<alienmax_y){
            b.used=true;
            a.x=3000;
            p.score+=10;
            if (p.score%100==0){
                b.levelUpUserGun();
                System.out.println("Wou");
            }
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        for (int i = 0; i < alien_row*alien_column; i++){
            alienList.get(i).draw(g2);
        }

        bullet.draw(g2);
        player.draw(g2,tileSize);


        g2.dispose();

    }


}
