package com.tutorial.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public int spd = 5;

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void clearEnemies(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            if(tempObject.getID() == ID.Player) {
                object.clear();
                if(Game.gameState != Game.STATE.End && Game.gameState != Game.STATE.Win)
                addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
            }
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){ this.object.remove(object);
    }

}
