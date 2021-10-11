package com.company.Hud_Effects;

import com.company.GameObjects.GameObject;
import com.company.Handler;
import com.company.GameObjects.ID;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1;
    private Handler handler;
    private Color color;
    private float life;

    public Trail(int x, int y, ID id, Color color, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.life = 0.03f;
    }

    @Override
    public void tick() {
        if(alpha > life){
            alpha-=(life-0.0001);
        }else{
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect(x,y,24,24);

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type,alpha));
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
