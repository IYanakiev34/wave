package com.company;

import com.company.GameObjects.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private LinkedList <GameObject> object = new LinkedList<>();

    public void tick(){
        for(int i=0;i<object.size();i++){
            GameObject temp = object.get(i);
            temp.tick();
        }
    }

    public void render(Graphics g){
        for(int i=0;i<object.size();i++){
            GameObject temp = object.get(i);
            temp.render(g);
        }
    }

    public LinkedList<GameObject> getList (){
        return object;
    }
    public void addObject (GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}
