package controllers.gameplay;

import components.bullets.Bullet;
import components.fighters.Fighter;
import controllers.GamePlay;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Thread that manage bullets actions (movement and hiting something)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class BulletManager implements Runnable{
    private static BulletManager instance;
    private GamePlay gamePlay;

    private BulletManager(GamePlay gamePlay){
        this.gamePlay = gamePlay;
    }

    public static BulletManager getInstance(GamePlay gamePlay) {
        if(instance == null)
            instance = new BulletManager(gamePlay);
        return instance;
    }

    @Override
    public void run(){
        while(gamePlay.isRunning()){
            // Need to get a copy to avoid concurrences errors
            Collection<Bullet> bullets = new ArrayList<>(gamePlay.getBullets());
            for(Bullet bullet : bullets){
                Fighter fighter = checkFighterOnNextLocation(bullet);
                if(fighter != null){
                    bullet.hit(fighter);
                    return;
                }
                else{
                    gamePlay.getView().removeComponent(bullet);
                    bullet.move();
                    gamePlay.getView().paintComponent(bullet);
                }
                // TODO : Check si bullet hors de la fenêtre
            }
            try {
                Thread.sleep(gamePlay.FRAMERATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Check if there's a fighter on the path of the bullet
     * @param bullet Bullet to check path
     * @return null if there's no fighter
     */
    private Fighter checkFighterOnNextLocation(Bullet bullet) {
        for(Fighter fighter : gamePlay.getMonsters()){
            if(bullet.checkNextLocation(fighter)){
                return fighter;
            }
        }
        return null;
    }
}
