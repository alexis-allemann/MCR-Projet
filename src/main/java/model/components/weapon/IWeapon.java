package model.components.weapon;

import controllers.Direction;
import model.components.fighters.IFighter;

public interface IWeapon {

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
}
