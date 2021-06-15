package model.components.fighters;

import model.components.physics.Location;
import controllers.Direction;
import model.components.weapon.LaserWeapon;
import model.components.weapon.Weapon;

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
        setWeapon(new LaserWeapon());
    }

    @Override
    public Direction getDirection() {
        return Direction.DOWN;
    }

    @Override
    public int getDefaultHealth() {
        return 1;
    }

    @Override
    public boolean isMonsterTeam() {
        return true;
    }
}
