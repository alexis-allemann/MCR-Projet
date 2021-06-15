package model.components.weapon;

import model.World;
import model.components.fighters.Fighter;
import model.components.physics.Location;
import model.components.weapon.bullets.Bullet;

import controllers.Direction;

/**
 * Weapon to shoot bullets
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Weapon {
    private long lastBulletShotTime = System.currentTimeMillis();
    private Fighter fighter;

    /**
     * Set weapon's owner
     *
     * @param fighter who owns the weapon
     */
    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
    }

    /**
     * Shoot a new bullet
     */
    public void shoot() {
        long current = System.currentTimeMillis();
        if (current - lastBulletShotTime >= reloadTime()) {
            Bullet bullet = getBullet(fighter.getDirection());
            bullet.setLocation(
                    getStartingBulletLocation(bullet)
            );
            World.getInstance().addBullet(bullet);
            lastBulletShotTime = System.currentTimeMillis();
        }
    }

    /**
     * Fighter who owns the weapon
     *
     * @return who owns the weapon
     */
    public Fighter getFighter() {
        return fighter;
    }

    /**
     * Get a new bullet
     *
     * @param direction direction the fighter is facing
     * @return bullet to shoot
     */
    abstract Bullet getBullet(Direction direction);

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
    Location getStartingBulletLocation(Bullet bullet) {
        float x = fighter.getLocation().x + fighter.getImageWidth() / 2.f;
        float y = fighter.getLocation().y + (fighter.getDirection() == Direction.TOP ? -1.5f : 1.5f) * fighter.getImageHeight();
        return new Location(x, y);
    }
}
