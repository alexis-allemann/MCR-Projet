package model.components.weapon.decorators;

import controllers.Direction;
import model.components.weapon.Projectile;

/**
 * Shoot power enhancer
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ShootPowerEnhancer extends WeaponDecorator {
    private final float ratio;

    /**
     * Instantiation of a new shoot power enhancer decoration
     *
     * @param ratio of the power to increment
     */
    public ShootPowerEnhancer(model.components.weapon.Weapon weapon, float ratio) {
        super(weapon);
        this.ratio = ratio;
    }

    @Override
    public Projectile getBullet(Direction direction) {
        Projectile oldProjectile = super.getBullet(direction);
        return new Projectile(oldProjectile.getImage(), oldProjectile.getSpeed(), oldProjectile.isMonsterTeam()) {
            @Override
            public int getPower() {
                return (int) (super.getPower() * ratio);
            }
        };
    }
}
