package model.components.weapon.decorators;

import utils.physics.Direction;
import model.components.weapon.IWeapon;
import model.components.weapon.Projectile;
import utils.Utils;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 * Shoot power enhancer
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ShootPowerEnhancer extends WeaponDecorator {
    private final float RATIO;

    /**
     * Instantiation of a new shoot power enhancer decoration
     *
     * @param ratio of the power to increment
     */
    public ShootPowerEnhancer(IWeapon weapon, float ratio) {
        super(weapon);
        this.RATIO = ratio;
    }

    @Override
    public Projectile getBullet(Direction direction) {
        Projectile oldProjectile = super.getBullet(direction);
        return new Projectile(oldProjectile.getImage(), oldProjectile.getSpeed(), oldProjectile.isMonsterTeam()) {
            @Override
            public int getPower() {
                return (int) (super.getPower() * RATIO);
            }
        };
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("power.png");
        graphics2D.drawImage(image, getLocation().getIntX(), getLocation().getIntY(), null);
    }
}
