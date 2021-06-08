package components.weapon;

import components.fighters.Fighter;
import components.physics.Location;
import components.weapon.bullets.Bullet;

import controllers.gameplay.BulletManager;

/**
 * Weapon to shoot bullets
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Weapon {
    private long lastBulletShotTime = System.currentTimeMillis();

    /**
     * Shoot a new bullet
     * @param fighter the fighter shooting with the weapon
     */
    public void shoot(Fighter fighter) {
        long current = System.currentTimeMillis();
        if (current - lastBulletShotTime >= reloadTime()) {
            Bullet bullet = getBullet();
            bullet.setLocation(
                    getStartingBulletLocation(fighter)
            );
            BulletManager.getInstance().addBullet(bullet);
            lastBulletShotTime = System.currentTimeMillis();
        }
    }

    /**
     * Get a new bullet
     *
     * @return bullet to shoot
     */
    abstract Bullet getBullet();

    /**
     * Reload time between shoots
     *
     * @return time between shoots
     */
    abstract int reloadTime();

    /**
     * Compute the starting location of the bullet
     *
     * @return the starting location of the bullet
     */
     abstract Location getStartingBulletLocation(Fighter fighter);
}
