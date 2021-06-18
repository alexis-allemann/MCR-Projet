package model.components.weapon.decorators;

import model.components.weapon.IWeapon;

/**
 * Reload speed enhancer
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ReloadSpeedEnhancer extends WeaponDecorator {
    private final float ratio;

    /**
     * Instantiation of a new reload speed enhancer decoration
     *
     * @param weapon to decorate
     * @param ratio  of the reload speed increment
     */
    public ReloadSpeedEnhancer(IWeapon weapon, float ratio) {
        super(weapon);
        this.ratio = ratio;
    }

    @Override
    public int reloadTimeInMilliSeconds() {
        return (int) (super.reloadTimeInMilliSeconds() * (1 - ratio));
    }
}
