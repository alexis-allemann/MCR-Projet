package model.components.weapon.decorators;

import controllers.Direction;
import model.components.weapon.Weapon;
import model.components.weapon.bullets.Bullet;

import java.awt.Image;

/**
 * Bullet size enhancer
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class BulletSizeEnhancer extends WeaponDecorator {
    private float ratio;

    /**
     * Instantiation of a new bullet size enhancer decoration
     *
     * @param ratio of the reload speed increment
     */
    public BulletSizeEnhancer(Weapon weapon, float ratio) {
        super(weapon);
        this.ratio = ratio;
    }

    @Override
    public Bullet getBullet(Direction direction) {
        Bullet oldBullet = super.getBullet(direction);
        Image oldImage = oldBullet.getImage();
        Image newImage = oldImage.getScaledInstance((int) (oldImage.getWidth(null) * ratio), (int) (oldImage.getHeight(null) * ratio), Image.SCALE_DEFAULT);
        return new Bullet(newImage, oldBullet.getSpeed(), oldBullet.isMonsterTeam()) {

        };
    }
}