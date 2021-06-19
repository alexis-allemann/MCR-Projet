package model.components.fighters;

import utils.Utils;
import utils.physics.Location;
import utils.physics.Direction;

/**
 * Space craft used to fight against monsters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpaceCraft extends Fighter {
    public static final int HEALTH = Integer.parseInt(Utils.getInstance().getProperty("SPACECRAFT_HEALTH"));
    public static final int SPEED = Integer.parseInt(Utils.getInstance().getProperty("SPACECRAFT_SPEED"));

    /**
     * Instantiation of a new spacecraft
     *
     * @param location where spacecraft is located
     */
    public SpaceCraft(Location location) {
        super(location, "spacecraft.png");
        setSpeed(SPEED, 0);
    }

    @Override
    public Direction getDirection() {
        return Direction.TOP;
    }

    @Override
    public int getDefaultHealth() {
        return HEALTH;
    }

    @Override
    public float getNextTimingModifier() {
        return 1.f;
    }

    @Override
    public boolean isMonsterTeam() {
        return false;
    }

    @Override
    public void move() {
        int oldLocationOnX = getLocation().getIntX();
        int oldLocationOnY = getLocation().getIntY();
        getLocation().translate(getSpeed().getX(), 0);
        if (!isInBounds())
            setLocation(new Location(oldLocationOnX, oldLocationOnY));
    }
}
