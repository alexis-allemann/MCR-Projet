package model.levels;

import model.components.fighters.IFighter;
import model.components.fighters.decorators.FighterDecorator;
import model.components.fighters.decorators.MultipleShoot;
import model.components.fighters.decorators.Shield;
import model.components.fighters.decorators.SpeedBoost;
import model.components.weapon.IWeapon;
import model.components.weapon.decorators.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Expert level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Expert extends Level {

    /**
     * Change level to expert
     *
     * @param oldLevel to retrieve attributes
     */
    public Expert(Level oldLevel) {
        super(oldLevel);
    }

    @Override
    public void checkLevelChanged() {
    }

    @Override
    public List<FighterDecorator> getFighterDecorators(final IFighter fighter) {
        return new ArrayList<FighterDecorator>() {{
            add(new Shield(fighter, 100));
            add(new SpeedBoost(fighter, 1.5f, 0));
            add(new MultipleShoot(fighter,3, 15));
        }};
    }

    @Override
    public List<WeaponDecorator> getWeaponDecorators(final IWeapon weapon) {
        return new ArrayList<WeaponDecorator>() {{
            add(new BulletSizeEnhancer(weapon, 2));
            add(new ShootPowerEnhancer(weapon, 1.5f));
            add(new ShootSpeedEnhancer(weapon, 1.5f));
        }};
    }

    @Override
    public float getMonsterShootTiming() {
        return 1.1f;
    }

    @Override
    public float getProbabilityOfMonstersToHaveDecorator() {
        return 0.5f;
    }

    @Override
    public float probabilityToGenerateDecoration() {
        return 0.5f;
    }

    @Override
    public int getNbMonsterByWave() {
        return 8;
    }

    @Override
    public String toString() {
        return "Expert";
    }
}
