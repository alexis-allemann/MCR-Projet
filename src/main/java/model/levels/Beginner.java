package model.levels;

import model.World;
import model.components.fighters.IFighter;
import model.components.fighters.decorators.FighterDecorator;
import model.components.weapon.IWeapon;
import model.components.weapon.decorators.WeaponDecorator;

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
        if (nbMonstersKilled >= 2 || getTimeInSeconds() > 20)
            World.getInstance().setLevel(new Easy(this));
    }

    @Override
    public float probabilityToGenerateDecoration() {
        return 0.3f;
    }

    @Override
    public List<FighterDecorator> getFighterDecorators(final IFighter fighter) {
        return null;
    }

    @Override
    public List<WeaponDecorator> getWeaponDecorators(final IWeapon weapon) {
        return null;
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
    String getMonsterImageName() {
        return "monster-green.png";
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
