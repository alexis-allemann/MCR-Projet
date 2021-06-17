package model.levels;

import model.World;
import model.components.fighters.Fighter;
import model.components.fighters.IFighter;
import model.components.fighters.Monster;
import model.components.fighters.decorators.FighterDecorator;
import model.components.fighters.decorators.Shield;
import model.components.fighters.decorators.SpeedBoost;
import model.components.weapon.IWeapon;
import model.components.weapon.decorators.BulletSizeEnhancer;
import model.components.weapon.decorators.ShootSpeedEnhancer;
import model.components.weapon.decorators.WeaponDecorator;
import utils.physics.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Hard level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Hard extends Level {

    /**
     * Change level to hard
     *
     * @param oldLevel to retrieve attributes
     */
    public Hard(Level oldLevel) {
        super(oldLevel);
    }

    @Override
    public void checkLevelChanged() {
        if (nbMonstersKilled >= 30 || getTime() > 120)
            World.getInstance().setLevel(new Expert(this));
    }

    @Override
    public List<FighterDecorator> getFighterDecorators(final IFighter fighter) {
        return new ArrayList<FighterDecorator>() {{
            add(new Shield(fighter, 50));
            add(new SpeedBoost(fighter, 2, 0));
        }};
    }

    @Override
    public List<WeaponDecorator> getWeaponDecorators(final IWeapon weapon) {
        return new ArrayList<WeaponDecorator>() {{
            add(new BulletSizeEnhancer(weapon, 2));
            add(new ShootSpeedEnhancer(weapon, 2));
        }};
    }

    @Override
    public float getMonsterShootTiming() {
        return 1.2f;
    }

    @Override
    public float getProbabilityOfMonstersToHaveDecorator() {
        return 0.4f;
    }

    @Override
    public float probabilityToGenerateDecoration() {
        return 0.1f;
    }

    @Override
    public int getNbMonsterByWave() {
        return 7;
    }

    @Override
    public String toString() {
        return "Hard";
    }
}
