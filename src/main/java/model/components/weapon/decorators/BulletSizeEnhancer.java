package model.components.weapon.decorators;

import controllers.Direction;
import model.components.weapon.Projectile;

import java.awt.Image;

/**
 * Bullet size enhancer
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class BulletSizeEnhancer extends WeaponDecorator {
    private final float ratio;

    /**
     * Instantiation of a new bullet size enhancer decoration
     *
     * @param ratio of the reload speed increment
     */
    public BulletSizeEnhancer(model.components.weapon.Weapon weapon, float ratio) {
        super(weapon);
        this.ratio = ratio;
    }

    @Override
    public Projectile getBullet(Direction direction) {
        Projectile oldProjectile = super.getBullet(direction);
        Image oldImage = oldProjectile.getImage();
        Image newImage = oldImage.getScaledInstance((int) (oldImage.getWidth(null) * ratio), (int) (oldImage.getHeight(null) * ratio), Image.SCALE_DEFAULT);
        return new Projectile(newImage, oldProjectile.getSpeed(), oldProjectile.isMonsterTeam()) {
            @Override
            public int getPower() {
                return 100;
            }
        };
    }
}