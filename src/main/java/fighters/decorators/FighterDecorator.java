package fighters.decorators;

import bullets.Bullet;
import fighters.Fighter;

/**
 * Space invaders fighters decorators
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class FighterDecorator implements Fighter {
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
}
