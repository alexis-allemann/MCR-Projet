package model.components.weapon.decorators;

import controllers.Direction;
import model.components.fighters.IFighter;
import model.components.weapon.IWeapon;
import model.components.weapon.Projectile;

/**
 * Weapon decorator
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class WeaponDecorator implements IWeapon {
    private final IWeapon weapon;

    /**
     * Instantiation of a new decoration
     *
     * @param weapon to decorate
     */
    public WeaponDecorator(IWeapon weapon) {
        this.weapon = weapon;
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
}
