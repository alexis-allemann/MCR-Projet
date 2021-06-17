package model.levels;

import model.World;
import model.components.fighters.IFighter;
import model.components.fighters.decorators.FighterDecorator;
import model.components.fighters.decorators.Shield;
import model.components.fighters.decorators.SpeedBoost;
import model.components.weapon.IWeapon;
import model.components.weapon.decorators.BulletSizeEnhancer;
import model.components.weapon.decorators.ShootSpeedEnhancer;
import model.components.weapon.decorators.WeaponDecorator;

import java.util.ArrayList;
import java.util.List;

/**
 * Beginner level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Beginner extends Level {

    @Override
    public void checkLevelChanged() {
        if (nbMonstersKilled >= 2 || getTime() > 20)
            World.getInstance().setLevel(new Easy(this));
    }

    @Override
    public float probabilityToGenerateDecoration() {
        return 0.3f;
    }

    @Override
    public List<FighterDecorator> getFighterDecorators(final IFighter fighter) {
        return new ArrayList<FighterDecorator>() {{
//            add(new Shield(fighter, 50));
            add(new SpeedBoost(fighter, 2, 0));
        }};
    }

    @Override
    public List<WeaponDecorator> getWeaponDecorators(final IWeapon weapon) {
        return new ArrayList<WeaponDecorator>() {{
            add(new BulletSizeEnhancer(weapon, 1.5f));
            add(new ShootSpeedEnhancer(weapon, 2));
        }};
    }

    @Override
    public float getMonsterShootTiming() {
        return 1.5f;
    }

    @Override
    public float getProbabilityOfMonstersToHaveDecorator() {
        return 0.1f;
    }

    @Override
    public int getNbMonsterByWave() {
        return 4;
    }

    @Override
    public String toString() {
        return "Beginner";
    }
}
