package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    private final int HEIGHT = 600;
    private final int WIDTH = 800;

    public Window(Game game){
        JFrame frame = new JFrame("Wave");
        frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH,HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
