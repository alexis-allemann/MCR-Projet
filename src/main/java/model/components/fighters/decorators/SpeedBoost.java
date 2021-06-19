package model.components.fighters.decorators;

import model.World;
import model.components.fighters.IFighter;
import utils.Utils;
import utils.physics.Location;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 * Boost applied on movement speed of model.components.fighters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpeedBoost extends FighterDecorator {
    private final float BOOST;

    /**
     * Apply speed boost
     *
     * @param fighter fighter to apply movement boost on
     * @param boost   amount to add to x axis
     */
    public SpeedBoost(IFighter fighter, float boost) {
        super(fighter);
        this.BOOST = boost;
    }

    @Override
    public void move() {
        fighter.move();
        if (!this.equals(World.getInstance().getSpacecraft())) {
            // Speed boost not allowed on monsters because it's the fighter manager that is responsible of moving monsters
            removeDecoration();
            return;
        }
        float oldLocationOnX = getLocation().getFloatX();
        float oldLocationOnY = getLocation().getFloatY();
        float boostSpeedX = fighter.getSpeed().getX() * BOOST;
        fighter.getLocation().translate(boostSpeedX, 0.f);
        if (!isInBounds()) {
            setLocation(new Location(oldLocationOnX, oldLocationOnY));
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("speed.png");
        graphics2D.drawImage(image, fighter.getLocation().getIntX(), fighter.getLocation().getIntY(), null);
    }
}
