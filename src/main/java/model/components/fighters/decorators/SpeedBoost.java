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
    public void move() {
        fighter.move();
        if (!this.equals(World.getInstance().getSpacecraft())) {
            // Speed boost not allowed on monsters because it's the fighter manager that is responsible of moving monsters
            removeDecoration();
            return;
        }
        Speed boostSpeed = new Speed(fighter.getSpeed().getX() * boostAmountX, 0);
        fighter.move(boostSpeed);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("speed.png");
        graphics2D.drawImage(image, fighter.getLocation().getIntX(), fighter.getLocation().getIntY(), null);
    }
}
