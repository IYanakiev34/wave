package com.company.Hud_Effects;

import com.company.Game;

import java.awt.*;

public class HUD {
    public static int HEALTH = 100;
    private int greenValue = 255;
    private float score = 0;
    private int level = 1;
    public void tick(){
        HEALTH = Game.clamp(HEALTH,0,100);
        greenValue = HEALTH*2+30;

        greenValue = Game.clamp(greenValue,0,255);
        score+= 0.5f;
    }

    public void render(Graphics graphics){
        graphics.setColor(Color.GRAY);
        graphics.fillRect(15,15,200,32);
        graphics.setColor(new Color(0,greenValue,0));
        graphics.fillRect(15,15,HEALTH*2,32);
        graphics.setColor(Color.WHITE);
        graphics.drawRect(15,15,200,32);
        graphics.drawString("SCORE: "+score,20,70);
        graphics.drawString("LEVEL: "+level,20,90);
    }
}
