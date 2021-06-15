package model.components.weapon.decorators;

import controllers.Direction;
import model.components.weapon.Weapon;
import model.components.weapon.bullets.Bullet;
import utils.physics.Vector2D;

/**
 * Shoot speed enhancer
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ShootSpeedEnhancer extends WeaponDecorator {
    private float ratio;

    /**
     * Instantiation of a new shoot speed enhancer decoration
     *
     * @param ratio of the shoot speed increment
     */
    public ShootSpeedEnhancer(Weapon weapon, float ratio) {
        super(weapon);
        this.ratio = ratio;
    }

    @Override
    public Bullet getBullet(Direction direction) {
        Bullet oldBullet = super.getBullet(direction);
        Vector2D newSpeed = new Vector2D(oldBullet.getSpeed().getX() * ratio, oldBullet.getSpeed().getY() * ratio);
        return new Bullet(oldBullet.getImage(), newSpeed, oldBullet.isMonsterTeam()) {
        };
    }
}
