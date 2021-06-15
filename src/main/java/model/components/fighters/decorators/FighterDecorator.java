package model.components.fighters.decorators;

import model.components.fighters.Fighter;
import controllers.Direction;
import model.components.weapon.Weapon;
import utils.physics.Location;

/**
 * Space invaders model.components.fighters decorators
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class FighterDecorator extends Fighter {
    protected Fighter fighter;

    /**
     * Instantiation of a new decoration
     *
     * @param fighter to decorate
     */
    public FighterDecorator(Fighter fighter) {
        super(fighter);
        this.fighter = fighter;
    }

    @Override
    public Direction getDirection() {
        return fighter.getDirection();
    }

    @Override
    public int getDefaultHealth() {
        return fighter.getDefaultHealth();
    }

    @Override
    public boolean isMonsterTeam() {
        return fighter.isMonsterTeam();
    }

    @Override
    public float getNextTimingModifier() {
        return fighter.getNextTimingModifier();
    }

    @Override
    public Location getLocation() {
        return fighter.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        fighter.setLocation(location);
    }

    @Override
    public Weapon getWeapon() {
        return fighter.getWeapon();
    }

    @Override
    public void setWeapon(Weapon weapon) {
        fighter.setWeapon(weapon);
    }

    @Override
    public Fighter removeDecorator(FighterDecorator decorator) {
        if (this == decorator) {
            return fighter;
        } else if (fighter instanceof FighterDecorator) {
            fighter = fighter.removeDecorator(decorator);
        }
        return this;
    }
}
