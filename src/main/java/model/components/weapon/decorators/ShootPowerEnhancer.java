package model.components.weapon.decorators;

import controllers.Direction;
import model.components.weapon.Weapon;
import model.components.weapon.bullets.Bullet;

/**
 * Shoot power enhancer
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ShootPowerEnhancer extends WeaponDecorator {
    private float ratio;

    /**
     * Instantiation of a new shoot power enhancer decoration
     *
     * @param ratio of the power to increment
     */
    public ShootPowerEnhancer(Weapon weapon, float ratio) {
        super(weapon);
        this.ratio = ratio;
    }

    @Override
    public Bullet getBullet(Direction direction) {
        Bullet oldBullet = super.getBullet(direction);
        return new Bullet(oldBullet.getImage(), oldBullet.getSpeed(), oldBullet.isMonsterTeam()) {
            @Override
            public int getPower() {
                return (int) (super.getPower() * ratio);
            }
        };
    }
}
