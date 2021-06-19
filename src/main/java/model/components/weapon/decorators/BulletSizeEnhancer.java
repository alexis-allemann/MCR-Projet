package model.components.weapon.decorators;

import utils.physics.Direction;
import model.components.weapon.IWeapon;
import model.components.weapon.Projectile;
import utils.Utils;

import java.awt.Image;
import java.awt.Graphics2D;

/**
 * Bullet size enhancer
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class BulletSizeEnhancer extends WeaponDecorator {
    private static final int NB_MAX_BULLET_SIZE_ENHANCER = Integer.parseInt(Utils.getInstance().getProperty("NB_MAX_BULLET_SIZE_ENHANCER"));
    private final float ratio;

    /**
     * Instantiation of a new bullet size enhancer decoration
     *
     * @param ratio of the reload speed increment
     */
    public BulletSizeEnhancer(IWeapon weapon, float ratio) {
        super(weapon);
        this.ratio = ratio;
        if (weapon.countDecorator(getClass()) > NB_MAX_BULLET_SIZE_ENHANCER - 1)
            removeDecoration();
    }

    @Override
    public Projectile getBullet(Direction direction) {
        Projectile oldProjectile = super.getBullet(direction);
        Image oldImage = oldProjectile.getImage();
        Image newImage = oldImage.getScaledInstance((int) (oldImage.getWidth(null) * ratio), (int) (oldImage.getHeight(null) * ratio), Image.SCALE_DEFAULT);
        return new Projectile(newImage, oldProjectile.getSpeed(), oldProjectile.isMonsterTeam()) {

        };
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("grow.png");
        graphics2D.drawImage(image, getLocation().getIntX(), getLocation().getIntY(), null);
    }
}