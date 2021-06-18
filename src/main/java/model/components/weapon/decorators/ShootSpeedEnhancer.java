package model.components.weapon.decorators;

import controllers.Direction;
import model.components.weapon.IWeapon;
import model.components.weapon.Projectile;
import utils.Utils;
import utils.physics.Vector2D;

import java.awt.*;

/**
 * Shoot speed enhancer
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ShootSpeedEnhancer extends WeaponDecorator {
    private final float ratio;

    /**
     * Instantiation of a new shoot speed enhancer decoration
     *
     * @param ratio of the shoot speed increment
     */
    public ShootSpeedEnhancer(IWeapon weapon, float ratio) {
        super(weapon);
        this.ratio = ratio;
    }

    @Override
    public Projectile getBullet(Direction direction) {
        Projectile oldProjectile = super.getBullet(direction);
        Vector2D newSpeed = new Vector2D(oldProjectile.getSpeed().getX() * ratio, oldProjectile.getSpeed().getY() * ratio);
        return new Projectile(oldProjectile.getImage(), newSpeed, oldProjectile.isMonsterTeam()) {
        };
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("shootspeed.png");
        graphics2D.drawImage(image, getLocation().getIntX(), getLocation().getIntY(), null);
    }
}
