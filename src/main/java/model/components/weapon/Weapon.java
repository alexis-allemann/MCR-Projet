package model.components.weapon;

import model.World;
import model.components.fighters.Fighter;
import utils.physics.Location;

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
    private long nextShootReloadTime;

    /**
     * Set weapon's owner
     *
     * @param fighter who owns the weapon
     */
    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
        setNextShootReloadTime();
    }

    /**
     * Shoot a new bullet
     */
    public void shoot() {
        long current = System.currentTimeMillis();
        if (current - lastBulletShotTime >= nextShootReloadTime) {
            Projectile projectile = fighter.getWeapon().getBullet(fighter.getDirection());
            projectile.setLocation(
                    getStartingBulletLocation(projectile)
            );
            World.getInstance().addBullet(projectile);
            lastBulletShotTime = System.currentTimeMillis();
            setNextShootReloadTime();
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
    public abstract Projectile getBullet(Direction direction);

    /**
     * Reload time between shoots
     *
     * @return time between shoots
     */
    public abstract int reloadTimeInMilliSeconds();

    /**
     * Compute the starting location of the bullet
     *
     * @return the starting location of the bullet
     */
    Location getStartingBulletLocation(Projectile projectile) {
        float x = fighter.getLocation().x + fighter.getImageWidth() / 2.f;
        float y = fighter.getLocation().y + (fighter.getDirection() == Direction.TOP ? -1.5f : 1.5f) * fighter.getImageHeight();
        return new Location(x, y);
    }

    /**
     * Set next shoot reload time
     */
    private void setNextShootReloadTime() {
        nextShootReloadTime = (long) (getFighter().getNextTimingModifier() * reloadTimeInMilliSeconds());
    }
}
