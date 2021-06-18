package model.components;

import model.components.fighters.IFighter;
import model.components.weapon.IWeapon;

/**
 * Decorator factory interface
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface IDecoratorFactory {

    /**
     * Get a fighter decorator
     *
     * @param fighter to decorate
     * @return the fighter decorated
     */
    IFighter createFighterDecorator(IFighter fighter);

    /**
     * Get a weapon decorator
     *
     * @param weapon to decorate
     * @return the weapon decorated
     */
    IWeapon createWeaponDecorator(IWeapon weapon);
}
