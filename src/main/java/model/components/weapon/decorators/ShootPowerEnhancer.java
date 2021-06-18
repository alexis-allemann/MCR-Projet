package model.components.weapon.decorators;

import controllers.Direction;
import model.components.weapon.IWeapon;
import model.components.weapon.Projectile;
import utils.Utils;

import java.awt.*;

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
    public ShootPowerEnhancer(IWeapon weapon, float ratio) {
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

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("power.png");
        graphics2D.drawImage(image, getLocation().getIntX(), getLocation().getIntY(), null);
    }
}
