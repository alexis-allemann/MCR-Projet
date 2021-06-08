package components.fighters.decorators;

import components.bullets.Bullet;
import components.fighters.GameComponent;

/**
 * Space invaders components.fighters decorators
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class FighterDecorator extends GameComponent {
    private GameComponent fighter;

    /**
     * Instantiation of a new decoration
     *
     * @param fighter to decorate
     */
    public FighterDecorator(GameComponent fighter) {
        super(fighter);
        this.fighter = fighter;
    }

    @Override
    public void shoot() {
        fighter.shoot();
    }

    @Override
    public Bullet getBullet() {
        return fighter.getBullet();
    }
}
