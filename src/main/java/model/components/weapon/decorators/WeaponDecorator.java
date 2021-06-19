package model.components.weapon.decorators;

import utils.physics.Direction;
import model.components.fighters.IFighter;
import model.components.weapon.IWeapon;
import model.components.weapon.Projectile;
import utils.physics.Location;

import java.awt.Image;
import java.awt.Graphics2D;

/**
 * Weapon decorator
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class WeaponDecorator implements IWeapon {
    private IWeapon weapon;

    /**
     * Instantiation of a new decoration
     *
     * @param weapon to decorate
     */
    public WeaponDecorator(IWeapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Remove decoration
     */
    protected void removeDecoration() {
        IFighter fighter = getFighter();
        if (fighter != null)
            fighter.setWeapon(fighter.getWeapon().removeDecorator(this));
    }

    @Override
    public int getId() {
        return weapon.getId();
    }

    @Override
    public Projectile getBullet(Direction direction) {
        return weapon.getBullet(direction);
    }

    @Override
    public int reloadTimeInMilliSeconds() {
        return weapon.reloadTimeInMilliSeconds();
    }

    @Override
    public IFighter getFighter() {
        return weapon.getFighter();
    }

    @Override
    public void shoot() {
        weapon.shoot();
    }

    @Override
    public void setFighter(IFighter fighter) {
        weapon.setFighter(fighter);
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
        return weapon.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        weapon.setLocation(location);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        weapon.draw(graphics2D);
    }

    @Override
    public boolean equals(Object o) {
        return weapon.equals(o);
    }

    @Override
    public final IWeapon removeDecorator(WeaponDecorator decorator) {
        if (this == decorator) {
            return weapon;
        } else {
            weapon = weapon.removeDecorator(decorator);
        }
        return this;
    }

    @Override
    public int countDecorator(Class decoratorClass) {
        if (getClass() == decoratorClass) {
            return weapon.countDecorator(decoratorClass) + 1;
        } else {
            return weapon.countDecorator(decoratorClass);
        }
    }

    @Override
    public int countDecorator() {
        return weapon.countDecorator() + 1;
    }
}
