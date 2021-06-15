package model.components.weapon.decorators;

import controllers.Direction;
import model.components.fighters.Fighter;
import model.components.weapon.Weapon;
import model.components.weapon.bullets.Bullet;

/**
 * Weapon decorator
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class WeaponDecorator extends Weapon {
    private final Weapon weapon;

    /**
     * Instantiation of a new decoration
     *
     * @param weapon to decorate
     */
    public WeaponDecorator(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public Bullet getBullet(Direction direction) {
        return weapon.getBullet(direction);
    }

    @Override
    public int reloadTimeInMilliSeconds() {
        return weapon.reloadTimeInMilliSeconds();
    }

    @Override
    public Fighter getFighter() {
        return weapon.getFighter();
    }

    @Override
    public void shoot() {
        weapon.shoot();
    }

    @Override
    public void setFighter(Fighter fighter) {
        weapon.setFighter(fighter);
    }
}
