package model.components.fighters.decorators;

import model.World;
import model.components.fighters.IFighter;
import model.components.fighters.SpaceCraft;
import utils.Utils;
import utils.physics.Speed;

import java.awt.*;

/**
 * Boost applied on movement speed of model.components.fighters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpeedBoost extends FighterDecorator {
    private final float boostAmountX;

    /**
     * Apply speed boost
     *
     * @param fighter      fighter to apply movement boost on
     * @param boostAmountX amount to add to x axis
     */
    public SpeedBoost(IFighter fighter, float boostAmountX) {
        super(fighter);
        this.boostAmountX = boostAmountX;
    }

    @Override
    public Speed getSpeed() {
        if (this.equals(World.getInstance().getSpacecraft())) {
            Speed resultingSpeed = new Speed();
            Speed actualSpeed = super.getSpeed();
            if(actualSpeed.getX() < 0)
                resultingSpeed.setX((SpaceCraft.SPEED * boostAmountX) * -1);
            else
                resultingSpeed.setX(SpaceCraft.SPEED * boostAmountX);
            return resultingSpeed;
        } else { // Speed boost not allowed on monsters because it's the fighter manager that is responsible of moving monsters
            removeDecoration();
            return super.getSpeed();
        }
    }

    @Override
    public void move() {
        fighter.move();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("speed.png");
        graphics2D.drawImage(image, fighter.getLocation().getIntX(), fighter.getLocation().getIntY(), null);
    }
}
