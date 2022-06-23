package main;

import entity.Alien;
import entity.Bullet;
import entity.Player;
import entity.Score;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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

    
    Player player=new Player(this,keyHand);
    Bullet bullet=new Bullet(this,keyHand);

    Score score=new Score(this,keyHand);

    int alien_row=8;
    int alien_column=3;
    public String direction="left";
    int FramesPerSecond=60;

    public void MoveAlien(Alien alien,String direction){
        if(direction=="right"){
            alien.x+=1;
        }else{
            alien.x-=1;
        }
    }

    public void populateAlienList(){
        int cordX=30;
        int cordY=25;
        for (int j=0;j < alien_column;j++) {
            for (int i = 0; i < alien_row; i++) {
                alienList.add(i, new Alien(this, keyHand, cordX, cordY));
                cordX += 75;
            }
            cordY += 50;
            cordX=30;
        }
    }
    
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
        int timeUnit=0;
        populateAlienList();

        while(gameThread!=null){
            updater(timeUnit);
            repaint();

            timeUnit+=1;

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

    public void updater(int timeUnit){
        player.updater(screenWidth,screenHeight,tileSize,bullet);
        bullet.updater();
        int aliensDeadCounter=0;

        if(timeUnit%120==0){
            if (direction=="right"){
                direction="left";
            }else{
                direction="right";
            }
        }

        for (int i = 0; i < alien_row*alien_column; i++){
            if(alienList.get(i).dead){
                aliensDeadCounter+=1;
            }else{
                colisionDetector(player,alienList.get(i),bullet);
                MoveAlien(alienList.get(i),direction);
            }
        }

        if (aliensDeadCounter==alien_row*alien_column){
            alienList.clear();
            populateAlienList();
        }
    }




    public void colisionDetector(Player p,Alien a,Bullet b){
        int alienmax_x=a.x+a.tileSizeWidth;
        int alienmin_x=a.x;
        int alienmax_y=a.y+a.tileSizeHeight;
        int alienmin_y=a.y;

        if(b.x+b.bulletSizeWidth>alienmin_x && b.x+b.bulletSizeWidth<alienmax_x){
            if(b.y+b.bulletSizeHeight>alienmin_y && b.y+b.bulletSizeHeight<alienmax_y){
                a.healthLevel-=b.damage;
                if(a.healthLevel<=0){
                    a.dead=true;
                    a.x=3000;
                }
                p.score+=10;
                b.used=true;

                if (p.score%100==0){
                    b.levelUpUserGun();
                }
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
        score.draw(g2,player.score,bullet.damage);
        g2.dispose();

    }


}
