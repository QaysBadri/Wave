package com.tutorial.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Game game;
    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud, Game game){
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }

    public void tick() {
        if(Game.gameState == Game.STATE.End || Game.gameState == Game.STATE.Win)
            scoreKeep = 0;
        else {
            scoreKeep++;
            if(scoreKeep >= 250) {
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);

                if(Game.diff == 0) {
                    switch(hud.getLevel()) {
                        case 2:
                        case 3:
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                            break;
                        case 4:
                        case 5:
                            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            break;
                        case 6:
                        case 7:
                            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                            break;
                        case 10:
                            handler.clearEnemies();
                            handler.addObject(new BossEnemy(((Game.WIDTH / 2) - 48), -120, ID.BossEnemy, handler));
                            break;
                        case 15:
                            handler.clearEnemies();
                            HUD.HEALTH += 50;
                            break;
                        case 16:
                            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                            break;
                        case 18:
                            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            break;
                        case 22:
                            handler.clearEnemies();
                            handler.addObject(new BossEnemy(((Game.WIDTH / 2) - 48), -120, ID.BossEnemy, handler));
                            break;
                        case 27:
                            handler.clearEnemies();
                            for(int i = 0;(i < 3);i++)
                                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            for(int i = 0;(i < 3);i++)
                                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            break;
                        case 30:
                            Game.gameState = Game.STATE.Win;
                            handler.clearEnemies();
                        default:
                            break;
                    }
                } else if(Game.diff == 1) {
                    switch(hud.getLevel()) {
                        case 2:
                        case 3:
                            handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HardEnemy, handler));
                            break;
                        case 4:
                        case 5:
                        case 6:
                            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            break;
                        case 7:
                        case 8:
                        case 9:
                            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                            break;
                        case 10:
                            handler.clearEnemies();
                            handler.addObject(new BossEnemy(((Game.WIDTH / 2) - 48), -120, ID.BossEnemy, handler));
                            break;
                        case 15:
                            handler.clearEnemies();
                            HUD.HEALTH += 50;
                            break;
                        case 16:
                            for(int i = 0;(i < 4);i++)
                                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                            break;
                        case 18:
                            for(int i = 0;(i < 4);i++)
                                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            for(int i = 0;(i < 4);i++)
                                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            break;
                        case 22:
                            handler.clearEnemies();
                            handler.addObject(new BossEnemy((Game.WIDTH / 2) - 48, -120, ID.BossEnemy, handler));
                            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                            break;
                        case 24:
                            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                            break;
                        case 27:
                            handler.clearEnemies();
                            for(int i = 0;(i < 3);i++)
                                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            for(int i = 0;(i < 3);i++)
                                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                            break;
                        case 28:
                            handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HardEnemy, handler));
                            handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HardEnemy, handler));
                        case 30:
                            Game.gameState = Game.STATE.Win;
                            handler.clearEnemies();
                            for(int i = 0; i < 20; i++)
                                handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
                        default:
                            break;
                    }
                }
            }
        }
    }
}