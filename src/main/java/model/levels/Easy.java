package model.levels;

import model.World;
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
 * Easy level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Easy extends Level {

    /**
     * Change level to easy
     *
     * @param oldLevel to retrieve attributes
     */
    public Easy(Level oldLevel) {
        super(oldLevel);
    }

    @Override
    public void checkLevelChanged() {
        if (nbMonstersKilled >= 5 || getTime() > 40)
            World.getInstance().setLevel(new Medium(this));
    }

    @Override
    public List<FighterDecorator> getFighterDecorators(final IFighter fighter) {
        return new ArrayList<FighterDecorator>() {{
            add(new Shield(fighter, 100));
            add(new SpeedBoost(fighter, 1.5f, 0));
            add(new MultipleShoot(fighter,2, 2));
        }};
    }

    @Override
    public List<WeaponDecorator> getWeaponDecorators(final IWeapon weapon) {
        return new ArrayList<WeaponDecorator>() {{
            add(new BulletSizeEnhancer(weapon, 2));
            add(new ReloadSpeedEnhancer(weapon, 1.5f));
            add(new ShootPowerEnhancer(weapon, 1.5f));
            add(new ShootSpeedEnhancer(weapon, 1.5f));
        }};
    }

    @Override
    public float getMonsterShootTiming() {
        return 1.4f;
    }

    @Override
    public float getProbabilityOfMonstersToHaveDecorator() {
        return 0.2f;
    }

    @Override
    public float probabilityToGenerateDecoration() {
        return 0.2f;
    }

    @Override
    public int getNbMonsterByWave() {
        return 5;
    }

    @Override
    public String toString() {
        return "Easy";
    }
}
