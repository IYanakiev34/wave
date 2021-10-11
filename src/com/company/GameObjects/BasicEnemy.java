package com.company.GameObjects;

import com.company.Handler;
import com.company.Hud_Effects.Trail;

import java.awt.*;

public class BasicEnemy extends GameObject {
    private final int SIZE = 24;
    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velY = 5;
        velX = 5;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if(x <=0 || x >= 800-SIZE){
            velX *= -1;
        }
        if(y <= 0 || y >=600-2*SIZE){
            velY *=-1;
        }
        handler.addObject(new Trail(x,y,ID.Trail,Color.RED,handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x,y,SIZE,SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,SIZE,SIZE);
    }
}
