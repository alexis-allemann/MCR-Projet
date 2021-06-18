package model.components.fighters.decorators;

import model.World;
import model.components.fighters.IFighter;
import utils.Utils;
import utils.physics.Vector2D;

import java.awt.*;

/**
 * Boost applied on movement speed of model.components.fighters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpeedBoost extends FighterDecorator {
    private final float boostAmountX;
    private final float boostAmountY;

    /**
     * Apply speedboost
     *
     * @param fighter      fighter to apply movement boost on
     * @param boostAmountX amount to add to x axis
     * @param boostAmountY amount to add to y axis
     */
    public SpeedBoost(IFighter fighter, float boostAmountX, float boostAmountY) {
        super(fighter);
        this.boostAmountX = boostAmountX;
        this.boostAmountY = boostAmountY;
    }

    @Override
    public Vector2D getSpeed() {
        if (this.equals(World.getInstance().getSpacecraft())) {
            Vector2D resultingSpeed = new Vector2D();
            Vector2D actualSpeed = super.getSpeed();

            resultingSpeed.setX(actualSpeed.getX() + boostAmountX);
            resultingSpeed.setY(actualSpeed.getY() + boostAmountY);

            return resultingSpeed;
        } else { // Speed boost not allowed on monsters because it's the fighter manager that is responsible of moving monsters
            removeDecoration();
            return super.getSpeed();
        }
    }

    @Override
    public void move() {
        fighter.move(getSpeed());
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("speed.png");
        graphics2D.drawImage(image, fighter.getLocation().getIntX(), fighter.getLocation().getIntY(), null);
    }
}
