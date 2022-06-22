package main;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Screen screen=new Screen();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Space Invaders");

        window.add(screen);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        screen.startGameThread();
    }
}
