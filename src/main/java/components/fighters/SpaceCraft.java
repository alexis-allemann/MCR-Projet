package components.fighters;

import components.physics.Location;
import controllers.Direction;

/**
 * Space craft used to fight against monsters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpaceCraft extends Fighter {

    /**
     * Instantiation of a new spacecraft
     *
     * @param location where spacecraft is located
     */
    public SpaceCraft(Location location) {
        super(location, "spacecraft.png");
    }

    @Override
    public boolean exist() {
        return true;
    }

    @Override
    public Direction getDirection() {
        return Direction.TOP;
    }
}
