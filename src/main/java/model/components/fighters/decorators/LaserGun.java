package components.fighters.decorators;

import components.fighters.Fighter;

/**
 * Laser gun to shoot laser components.weapon.bullets
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
