package com.company;

import com.company.Controller.KeyInput;
import com.company.GameObjects.BasicEnemy;
import com.company.GameObjects.ID;
import com.company.GameObjects.Player;
import com.company.Hud_Effects.HUD;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    private boolean running = true;
    private Handler handler;
    private HUD hud;

    public Game(){
        this.handler = new Handler();
        this.hud = new HUD();

        handler.addObject(new Player(300,300, ID.Player,handler));
        handler.addObject(new BasicEnemy(500,200,ID.Enemy,handler));
        handler.addObject(new BasicEnemy(200,100,ID.Enemy,handler));
        handler.addObject(new BasicEnemy(300,500,ID.Enemy,handler));
        handler.addObject(new BasicEnemy(550,50,ID.Enemy,handler));
        handler.addObject(new BasicEnemy(100,200,ID.Enemy,handler));
        this.addKeyListener(new KeyInput(handler));
    }

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        SwingUtilities.invokeLater(()->
                new Window(new Game()));
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 /amountOfTicks;
        double delta = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta --;
            }
            render();
        }
    }


    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
    }

    private void tick(){
        handler.tick();
        hud.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        //clearing last frame
        g.setColor(Color.BLACK);
        g.fillRect(0,0,800,600);

        //drawing objects
        hud.render(g);
        handler.render(g);


        //new frame
        g.dispose();
        bs.show();
    }

    public static int clamp(int var,int min,int max){
        if(var >=max){
            return max;
        }else if (var <= min){
            return min;
        }
        return var;
    }
}
