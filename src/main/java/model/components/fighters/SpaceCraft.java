package model.components.fighters;

import utils.physics.Location;
import controllers.Direction;
import utils.physics.Vector2D;

/**
 * Space craft used to fight against monsters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpaceCraft extends Fighter {
    public static final int MAX_HEALTH = 1000;

    /**
     * Instantiation of a new spacecraft
     *
     * @param location where spacecraft is located
     */
    public SpaceCraft(Location location) {
        super(location, "spacecraft.png");
    }

    @Override
    public Direction getDirection() {
        return Direction.TOP;
    }

    @Override
    public int getDefaultHealth() {
        return MAX_HEALTH;
    }

    @Override
    public float getNextTimingModifier() {
        return 1.f;
    }

    @Override
    public void die() {
        // TODO: trigger game stop here/restart
        System.out.println("Game over !");
    }

    @Override
    public boolean isMonsterTeam() {
        return false;
    }

    @Override
    public Vector2D getSpeed() {
        return new Vector2D(10.f, 0);
    }
}
