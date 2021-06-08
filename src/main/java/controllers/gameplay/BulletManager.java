package controllers.gameplay;

import components.weapon.bullets.Bullet;
import components.fighters.Fighter;
import controllers.GamePlay;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Thread that manage bullets actions (movement and hiting something)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class BulletManager implements Runnable {
    private static BulletManager instance = new BulletManager();
    private Collection<Bullet> bullets = new LinkedList<>();

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
            // Need to get a copy to avoid concurrences errors
            Collection<Bullet> bulletsList = new ArrayList<>(bullets);
            for (Bullet bullet : bulletsList) {
                Fighter fighter = checkFighterOnNextLocation(bullet);
                if (fighter != null) {
                    bullet.hit(fighter);
                    return;
                } else {
                    ViewManager.getInstance().removeComponent(bullet);
                    bullet.move();
                    ViewManager.getInstance().paintComponent(bullet);
                }
                // TODO : Check si bullet hors de la fenêtre
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

        this.bullets.add(bullet);
    }

    /**
     * Check if there's a fighter on the path of the bullet
     *
     * @param bullet Bullet to check path
     * @return the fighter or null if there's no fighter
     */
    private Fighter checkFighterOnNextLocation(Bullet bullet) {
        for (Fighter fighter : FighterManager.getInstance().getMonsters()) {
            if (bullet.checkNextLocation(fighter)) {
                return fighter;
            }
        }
        return null;
    }
}
