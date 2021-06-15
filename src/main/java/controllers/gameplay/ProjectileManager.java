package controllers.gameplay;

import model.World;
import model.components.weapon.Projectile;
import model.components.fighters.Fighter;

import java.util.LinkedList;

/**
 * Thread that manage bullets actions (movement and hitting something)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ProjectileManager {
    private static final ProjectileManager INSTANCE = new ProjectileManager();

    /**
     * Instantiation of the bullet manager
     */
    private ProjectileManager() {
    }

    /**
     * Get instance of the bullet manager to implement singleton pattern
     *
     * @return the instance of the bullet manager
     */
    public static ProjectileManager getInstance() {
        return INSTANCE;
    }

    /**
     * Manage bullets actions
     */
    public void manage() {
        // Lock bullets list instance to prevent concurrences errors
        synchronized (World.getInstance().getBullets()) {
            LinkedList<Projectile> bulletsToRemove = new LinkedList<>();
            for (Projectile projectile : World.getInstance().getBullets()) {

                // Check if a fighter has been touched by bullet
                Fighter fighter = checkFighterOnNextLocation(projectile);
                if (fighter != null) {
                    projectile.hit(fighter);
                    bulletsToRemove.add(projectile);
                } else {
                    projectile.move();
                    if (!projectile.isInBounds()) {
                        bulletsToRemove.add(projectile);
                    }
                }
            }

            // Remove monster after iteration to handle concurrence in synchronised list
            for (Projectile projectile : bulletsToRemove)
                World.getInstance().removeBullet(projectile);
        }
    }

    /**
     * Check if there's a fighter on the path of the bullet
     *
     * @param projectile Bullet to check path
     * @return the fighter or null if there's no fighter
     */
    private Fighter checkFighterOnNextLocation(Projectile projectile) {

        // Check if the spacecraft has been touched
        if (projectile.checkNextLocation(World.getInstance().getSpacecraft()))
            return World.getInstance().getSpacecraft();

        // Check if a monster has been touched
        synchronized (World.getInstance().getMonsters()) {
            for (Fighter monster : World.getInstance().getMonsters())
                if (projectile.checkNextLocation(monster))
                    return monster;
        }

        return null;
    }
}
