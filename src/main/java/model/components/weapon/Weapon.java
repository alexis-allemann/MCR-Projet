package model.components.weapon;

import model.World;
import model.components.fighters.IFighter;
import model.components.weapon.decorators.WeaponDecorator;
import utils.physics.Location;

import utils.physics.Direction;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 * Weapon to shoot bullets
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Weapon implements IWeapon {
    private static int nb;
    private final int id = nb++;
    private long lastBulletShotTime = System.currentTimeMillis();
    private IFighter fighter;
    private long nextShootReloadTime;

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
                    getStartingBulletLocation()
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
    private Location getStartingBulletLocation() {
        float x = fighter.getLocation().getFloatX() + fighter.getImageWidth() / 2.f;
        float y = fighter.getLocation().getFloatY() + (fighter.getDirection() == Direction.TOP ? -1.5f : 1.5f) * fighter.getImageHeight();
        return new Location(x, y);
    }

    /**
     * Set next shoot reload time
     */
    private void setNextShootReloadTime() {
        nextShootReloadTime = (long) (getFighter().getNextTimingModifier() * reloadTimeInMilliSeconds());
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public int getImageWidth() {
        return 0;
    }

    @Override
    public int getImageHeight() {
        return 0;
    }

    @Override
    public Location getLocation() {
        return fighter.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        fighter.setLocation(location);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        IWeapon weapon = (IWeapon) o;
        return id == weapon.getId();
    }

    @Override
    public IWeapon removeDecorator(WeaponDecorator decorator) {
        return this;
    }

    @Override
    public int countDecorator(Class decoratorClass) {
        return 0;
    }

    @Override
    public int countDecorator() {
        return 0;
    }
}
