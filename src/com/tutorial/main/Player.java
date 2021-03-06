package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y, 32, 32);
    }

    public void tick(){
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 50);
        y = Game.clamp(y, 0, Game.HEIGHT - 73);

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.white, 32, 32, 0.05f, handler));

        collision();

    }

    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy || tempObject.getID() == ID.BossEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 2;
                }
            }

        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, 32, 32);
    }

}
