package components.fighters.decorators;

import components.bullets.Bullet;
import components.fighters.GameComponent;

import java.awt.Image;

/**
 * Laser gun to shoot laser components.bullets
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class LaserGun extends FighterDecorator {

    /**
     * Instantiation of a new laser gun
     *
     * @param fighter to decorate
     */
    public LaserGun(GameComponent fighter) {
        super(fighter);
    }

    @Override
    public Bullet getBullet() {
        return null;
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public boolean exist() {
        return true;
    }
}
