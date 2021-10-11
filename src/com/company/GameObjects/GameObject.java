package com.company.GameObjects;

import java.awt.*;

public abstract class GameObject {

    protected int x,y;
    protected  float velX,velY;
    protected ID id;

    public GameObject(int x,int y,ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();


    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setId(ID id){
        this.id = id;
    }

    public ID getID(){
        return this.id;
    }

    public void setVelX(float velX){
        this.velX = velX;
    }

    public float getVelX(){
        return this.velX;
    }

    public void setVelY(float velY){
        this.velY = velY;
    }

    public float getVelY(){
        return this.velY;
    }
}
