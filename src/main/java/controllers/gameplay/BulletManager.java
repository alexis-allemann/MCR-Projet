package controllers.gameplay;

import model.World;
import model.components.weapon.bullets.Bullet;
import model.components.fighters.Fighter;
import controllers.GamePlay;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Thread that manage bullets actions (movement and hiting something)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class BulletManager implements Runnable {
    private static BulletManager instance = new BulletManager();

    /**
     * Instantiation of the bullet manager
     */
    private BulletManager() {
    }

    /**
     * Get instance of the bullet manager to implement singleton pattern
     *
     * @return the instance of the bullet manager
     */
    public static BulletManager getInstance() {
        return instance;
    }

    @Override
    public void run() {
        while (GamePlay.getInstance().isRunning()) {
            synchronized (retrieveBullets()) {
                List<Bullet> bulletsToRemove = new LinkedList();
                for (Bullet bullet : retrieveBullets()) {
                    Fighter fighter = checkFighterOnNextLocation(bullet);
                    if (fighter != null) {
                        bullet.hit(fighter);
                        bulletsToRemove.add(bullet);
                    } else {
                        bullet.move();
                        if(!bullet.isInBounds()){
                            bulletsToRemove.add(bullet);
                        }
                    }

                }
                for(Bullet bullet : bulletsToRemove){
                    World.getInstance().removeBullet(bullet);
                }
            }
            try {
                Thread.sleep(GamePlay.FRAMERATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Add a new bullet in the game
     *
     * @param bullet to add
     */
    public void addBullet(Bullet bullet) {
        retrieveBullets().add(bullet);
    }

    /**
     * Check if there's a fighter on the path of the bullet
     *
     * @param bullet Bullet to check path
     * @return the fighter or null if there's no fighter
     */
    private Fighter checkFighterOnNextLocation(Bullet bullet) {
        if(bullet.checkNextLocation(World.getInstance().getSpacecraft())){
            return World.getInstance().getSpacecraft();
        }
        for (Fighter monster : retrieveMonsters()) {
            if (bullet.checkNextLocation(monster)) {
                System.out.println("Hit monster " + monster.getLocation().x );
                return monster;
            }
        }
        return null;
    }

    private List<Bullet> retrieveBullets(){ return World.getInstance().getBullets();}
    private List<Fighter> retrieveMonsters(){ return World.getInstance().getMonsters();}
}
