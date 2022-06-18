package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean upActivated;
    public boolean downActivated;
    public boolean leftActivated;
    public boolean rightActivated;
    public boolean spaceActivated;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();

        if (keyCode==KeyEvent.VK_W){
            upActivated=true;
        }
        if (keyCode==KeyEvent.VK_S){
            downActivated=true;
        }
        if (keyCode==KeyEvent.VK_A){
            leftActivated=true;
        }
        if (keyCode==KeyEvent.VK_D){
            rightActivated=true;
        }
        if (keyCode==KeyEvent.VK_SPACE){
            spaceActivated=true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int keyCode=e.getKeyCode();

        if (keyCode==KeyEvent.VK_W){
            upActivated=false;
        }
        if (keyCode==KeyEvent.VK_S){
            downActivated=false;
        }
        if (keyCode==KeyEvent.VK_A){
            leftActivated=false;
        }
        if (keyCode==KeyEvent.VK_D){
            rightActivated=false;
        }
        if (keyCode==KeyEvent.VK_SPACE){
            spaceActivated=false;
        }
    }
}
