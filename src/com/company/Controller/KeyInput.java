package com.company.Controller;

import com.company.GameObjects.GameObject;
import com.company.Handler;
import com.company.GameObjects.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class KeyInput extends KeyAdapter {

    private final Handler handler;
    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent ev){
        int key = ev.getKeyCode();
        LinkedList<GameObject> objects = handler.getList();

        for(int i = 0; i<objects.size();i++){
            GameObject temp = objects.get(i);
            if(temp.getID() == ID.Player){
                switch (key){
                    case KeyEvent.VK_W:
                        temp.setVelY(-5);
                        break;
                    case KeyEvent.VK_S:
                        temp.setVelY(5);
                        break;
                    case KeyEvent.VK_A:
                        temp.setVelX(-5);
                        break;
                    case KeyEvent.VK_D:
                        temp.setVelX(+5);
                        break;
                }
            }
        }
    }

    public void keyReleased(KeyEvent ev){
        int key = ev.getKeyCode();
        LinkedList<GameObject> objects = handler.getList();

        for(int i = 0; i<objects.size();i++){
            GameObject temp = objects.get(i);
            if(temp.getID() == ID.Player){
                switch (key){
                    case KeyEvent.VK_W:
                        temp.setVelY(0);
                        break;
                    case KeyEvent.VK_S:
                        temp.setVelY(0);
                        break;
                    case KeyEvent.VK_A:
                        temp.setVelX(0);
                        break;
                    case KeyEvent.VK_D:
                        temp.setVelX(0);
                        break;
                }
            }
        }
    }
}
