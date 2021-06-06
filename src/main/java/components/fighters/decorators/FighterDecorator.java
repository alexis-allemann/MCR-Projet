package components.fighters.decorators;

import components.bullets.Bullet;
import components.fighters.Fighter;

import java.awt.Image;
import java.awt.Point;

/**
 * Space invaders components.fighters decorators
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
        super(fighter);
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
}
