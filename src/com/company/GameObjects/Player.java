package com.company.GameObjects;

import com.company.Game;
import com.company.Hud_Effects.HUD;
import com.company.Handler;

import java.awt.*;
import java.util.LinkedList;

public class Player extends GameObject {
    private final int SIZE = 32;
    private Handler handler;
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = 0;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        x = Game.clamp(x,0,800-SIZE);
        y = Game.clamp(y,0,600-2*SIZE);

        collision();
    }

    private void collision(){
        LinkedList<GameObject> objects = handler.getList();

        for(int i = 0; i < objects.size(); i++){
            GameObject temp = objects.get(i);

            if(temp.getID() == ID.Enemy){
                if(temp.getBounds().intersects(this.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x,y,SIZE,SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,SIZE,SIZE);
    }
}
