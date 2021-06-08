package controllers.gameplay;

import components.bullets.Bullet;
import components.fighters.GameComponent;
import controllers.GamePlay;

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
            for(Bullet bullet : gamePlay.getBullets()){
                GameComponent fighter = checkFighterOnNextLocation(bullet);
                if(fighter != null)
                    bullet.hit(fighter);
                else
                    bullet.move();
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
    private GameComponent checkFighterOnNextLocation(Bullet bullet) {
        for(GameComponent fighter : gamePlay.getFighters()){
            if(bullet.checkNextLocation(fighter)){
                return fighter;
            }
        }
        return null;
    }
}
