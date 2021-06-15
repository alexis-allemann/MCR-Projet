package controllers.gameplay;

import model.World;
import model.components.weapon.bullets.Bullet;
import model.components.fighters.Fighter;
import controllers.GamePlay;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Check if game is still running
                if (!GamePlay.getInstance().isRunning()) {
                    cancel();
                    timer.cancel();
                }

                // Lock bullets list instance to prevent concurrences errors
                synchronized (World.getInstance().getBullets()) {
                    List<Bullet> bulletsToRemove = new LinkedList();
                    for (Bullet bullet : World.getInstance().getBullets()) {

                        // Check if a fighter has been touched by bullet
                        Fighter fighter = checkFighterOnNextLocation(bullet);
                        if (fighter != null) {
                            bullet.hit(fighter);
                            bulletsToRemove.add(bullet);
                        } else {
                            bullet.move();
                            if (!bullet.isInBounds()) {
                                bulletsToRemove.add(bullet);
                            }
                        }
                    }

                    // Remove monster after iteration to handle concurrence in synchronised list
                    for (Bullet bullet : bulletsToRemove)
                        World.getInstance().removeBullet(bullet);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, GamePlay.FRAME_RATE);
    }

    /**
     * Check if there's a fighter on the path of the bullet
     *
     * @param bullet Bullet to check path
     * @return the fighter or null if there's no fighter
     */
    private Fighter checkFighterOnNextLocation(Bullet bullet) {

        // Check if the spacecraft has been touched
        if (bullet.checkNextLocation(World.getInstance().getSpacecraft()))
            return World.getInstance().getSpacecraft();

        // Check if a monster has been touched
        for (Fighter monster : World.getInstance().getMonsters())
            if (bullet.checkNextLocation(monster))
                return monster;

        return null;
    }
}
