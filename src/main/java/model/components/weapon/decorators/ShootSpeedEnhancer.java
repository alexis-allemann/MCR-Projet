package model.components.weapon.decorators;

import utils.physics.Direction;
import model.components.weapon.IWeapon;
import model.components.weapon.Projectile;
import utils.Utils;
import utils.physics.Speed;

import java.awt.Image;
import java.awt.Graphics2D;

/**
 * Shoot speed enhancer
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ShootSpeedEnhancer extends WeaponDecorator {
    private final float RATIO;

    /**
     * Instantiation of a new shoot speed enhancer decoration
     *
     * @param weapon weapon to enhance shoot speed
     * @param ratio  of the shoot speed increment
     */
    public ShootSpeedEnhancer(IWeapon weapon, float ratio) {
        super(weapon);
        this.RATIO = ratio;
    }

    @Override
    public Projectile getBullet(Direction direction) {
        Projectile oldProjectile = super.getBullet(direction);
        Speed newSpeed = new Speed(oldProjectile.getSpeed().getX() * RATIO, oldProjectile.getSpeed().getY() * RATIO);
        return new Projectile(oldProjectile.getImage(), newSpeed, oldProjectile.isMonsterTeam()) {
        };
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("shoot_speed.png");
        graphics2D.drawImage(image, getLocation().getIntX(), getLocation().getIntY(), null);
    }
}
