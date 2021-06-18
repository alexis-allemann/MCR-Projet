package model.components.weapon;

import model.World;
import model.components.fighters.Fighter;
import model.components.fighters.IFighter;
import utils.physics.Location;

import controllers.Direction;

import java.util.Objects;

/**
 * Weapon to shoot bullets
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Weapon implements IWeapon {
    private long lastBulletShotTime = System.currentTimeMillis();
    private IFighter fighter;
    private long nextShootReloadTime;
    private static int nb;
    private final int id = nb++;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public IFighter getFighter() {
        return fighter;
    }

    @Override
    public void setFighter(IFighter fighter) {
        this.fighter = fighter;
        setNextShootReloadTime();
    }

    @Override
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
     * Compute the starting location of the bullet
     *
     * @return the starting location of the bullet
     */
    private Location getStartingBulletLocation(Projectile projectile) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        IWeapon weapon = (IWeapon) o;
        return id == weapon.getId();
    }
}
