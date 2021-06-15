package model.components.fighters.decorators;

import model.components.fighters.Fighter;
import controllers.Direction;

/**
 * Space invaders model.components.fighters decorators
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
    public Direction getDirection() {
        return fighter.getDirection();
    }

    @Override
    public int getDefaultHealth() {
        return fighter.getDefaultHealth();
    }
}
