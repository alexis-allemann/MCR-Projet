package model.components.fighters.decorators;

import model.components.fighters.Fighter;

/**
 * Laser gun to shoot laser model.components.weapon.bullets
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class LaserGun extends FighterDecorator {

    /**
     * Instantiation of a new laser gun
     *
     * @param fighter to decorate
     */
    public LaserGun(Fighter fighter) {
        super(fighter);
    }
}
