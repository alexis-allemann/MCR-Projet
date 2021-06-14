package model.components.fighters;

import model.components.physics.Location;
import controllers.Direction;

/**
 * Monsters used to fight against space craft
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Monster extends Fighter {

    /**
     * Instantiation of a new monster
     *
     * @param location where monster is located
     */
    public Monster(Location location) {
        super(location, "monster-green.png");
    }

    @Override
    public Direction getDirection() {
        return Direction.DOWN;
    }

}
