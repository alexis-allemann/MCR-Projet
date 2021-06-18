package model.components.weapon;

import controllers.Direction;
import model.components.IGameComponent;
import model.components.fighters.IFighter;

/**
 * Weapon interface
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface IWeapon extends IGameComponent {

    /**
     * Get id of the weapon
     *
     * @return id of the weapon
     */
    int getId();

    /**
     * Set weapon's owner
     *
     * @param fighter who owns the weapon
     */
    void setFighter(IFighter fighter);

    /**
     * Shoot a new bullet
     */
    void shoot();

    /**
     * Fighter who owns the weapon
     *
     * @return who owns the weapon
     */
    IFighter getFighter();

    /**
     * Get a new bullet
     *
     * @param direction direction the fighter is facing
     * @return bullet to shoot
     */
    Projectile getBullet(Direction direction);

    /**
     * Reload time between shoots
     *
     * @return time between shoots
     */
    int reloadTimeInMilliSeconds();

    /**
     * Count decorators from a specific class down the chain
     *
     * @param decoratorClass the class to count the number of decorator from
     * @return the number of decorator belonging to the class
     */
    int countDecorator(Class decoratorClass);
}
