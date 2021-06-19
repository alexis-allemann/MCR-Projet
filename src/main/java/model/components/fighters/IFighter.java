package model.components.fighters;

import utils.physics.Direction;
import model.components.IGameComponentWithHitBox;
import model.components.fighters.decorators.FighterDecorator;
import model.components.weapon.IWeapon;

/**
 * Fighter interface
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface IFighter extends IGameComponentWithHitBox {

    /**
     * Get id of the fighter
     *
     * @return id of the fighter
     */
    int getId();

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
    boolean isAlive();

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
     * Get if the fighter can be decorated
     *
     * @return boolean if the fighter can be decorated
     */
    boolean canBeDecorated();

    /**
     * Remove decorator from fighter
     *
     * @param decorator to remove
     * @return fighter without given decoration
     */
    IFighter removeDecorator(FighterDecorator decorator);

    /**
     * Count decorators from a specific class down the chain
     *
     * @param decoratorClass the class to count the number of decorator from
     * @return the number of decorator belonging to the class
     */
    int countDecorator(Class decoratorClass);

    /**
     * Count decorators  down the chain
     *
     * @return the number of decorator belonging to the class
     */
    int countDecorator();
}
