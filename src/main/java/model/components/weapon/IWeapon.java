package model.components.weapon;

import utils.physics.Direction;
import model.components.IGameComponent;
import model.components.fighters.IFighter;
import model.components.weapon.decorators.WeaponDecorator;

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
     * Fighter who owns the weapon
     *
     * @return who owns the weapon
     */
    IFighter getFighter();

    /**
     * Shoot a new bullet
     */
    void shoot();

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
     * Remove decorator from weapon
     *
     * @param decorator to remove
     * @return weapon without given decoration
     */
    IWeapon removeDecorator(WeaponDecorator decorator);

    /**
     * Count decorators from a specific class down the chain
     *
     * @param decoratorClass the class to count the number of decorator from
     * @return the number of decorator belonging to the class
     */
    int countDecorator(Class decoratorClass);

    /**
     * Count decorators down the chain
     *
     * @return the number of decorator belonging to the class
     */
    int countDecorator();
}
