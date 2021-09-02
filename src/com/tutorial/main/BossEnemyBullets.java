package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class BossEnemyBullets extends GameObject{

    private Handler handler;
    Random r = new Random();

    public BossEnemyBullets(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        //velX = r.nextInt((5 -  -5) + -5);
        velX = r.nextInt(10) - 5;
        velY = 5;
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        //if(y <= 0 || y >= Game.HEIGHT - 60) velY *= -1;
        //if(x <= 0 || x >= Game.WIDTH - 37) velX *= -1;

        if(y >= Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.red, 16, 16, 0.03f, handler));
    }


    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 16, 16);
    }

}
