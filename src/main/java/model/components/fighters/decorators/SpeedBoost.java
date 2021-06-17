package model.components.fighters.decorators;

import model.components.fighters.Fighter;
import utils.physics.Vector2D;

/**
 * Boost applied on movement speed of model.components.fighters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpeedBoost extends FighterDecorator {

    private final int boostAmountX;
    private final int boostAmountY;

    /**
     * Apply speedboost
     *
     * @param fighter      fighter to apply movement boost on
     * @param boostAmountX amount to add to x axis
     * @param boostAmountY amount to add to y axis
     */
    public SpeedBoost(Fighter fighter, int boostAmountX, int boostAmountY) {
        super(fighter);
        this.boostAmountX = boostAmountX;
        this.boostAmountY = boostAmountY;
    }

    @Override
    public Vector2D getSpeed() {
        Vector2D resultingSpeed = new Vector2D();
        Vector2D actualSpeed = fighter.getSpeed();

        resultingSpeed.setX(actualSpeed.getX() + boostAmountX);
        resultingSpeed.setY(actualSpeed.getY() + boostAmountY);

        return resultingSpeed;
    }

}
