package fighters.decorators;

import bullets.Bullet;
import fighters.Fighter;


import java.awt.*;

/**
 * Space invaders fighters decorators
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class FighterDecorator extends Fighter {
    private Fighter fighter;

    /**
     * Instantiation of a new decoration
     *
     * @param fighter to decorate
     */
    public FighterDecorator(Fighter fighter) {
        this.fighter = fighter;
    }

    @Override
    public void fight() {
        fighter.fight();
    }

    @Override
    public Bullet getBullet() {
        return fighter.getBullet();
    }

    @Override
    public Image getImage() {
        return fighter.getImage();
    }

    @Override
    public Point getPosition() {
        return fighter.getPosition();
    }

    @Override
    public void setPosition(Point point) {
        fighter.setPosition(point);
    }
}
