package model.components.fighters;

import controllers.Direction;
import model.components.IGameComponentWithHitBox;
import model.components.fighters.decorators.FighterDecorator;
import model.components.weapon.IWeapon;
import utils.physics.Vector2D;

/**
 * Fighter interface
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface IFighter extends IGameComponentWithHitBox {

    /**
     * Get shoot direction
     *
     * @return the shoot direction
     */
    Direction getDirection();

    /**
     * Get default health
     *
     * @return default health
     */
    int getDefaultHealth();

    /**
     * Get next timing modifier
     *
     * @return next timing modifier
     */
    float getNextTimingModifier();

    /**
     * Get the fighter's weapon
     *
     * @return fighter's weapon
     */
    IWeapon getWeapon();

    /**
     * Set the fighter's weapon
     *
     * @param weapon Weapon to set
     */
    void setWeapon(IWeapon weapon);


    /**
     * Get fighter's health
     *
     * @return fighter's health
     */
    int getHealth();

    /**
     * Removing healing points to the fighter's health
     *
     * @param hp healing points to remove
     */
    void removeHealth(int hp);

    /**
     * Check if fighter is still alive
     *
     * @return true if fighter is alive
     */
    boolean alive();

    /**
     * shoot with weapon
     */
    void shoot();

    /**
     * Death action
     */
    void die();

    /**
     * Value of the fighter for the score
     *
     * @return Number of points that represent the fighter's value
     */
    int getPoints();

    /**
     * Remove decorator from fighter
     *
     * @param decorator to remove
     * @return fighter without given decoration
     */
    IFighter removeDecorator(FighterDecorator decorator);
}
