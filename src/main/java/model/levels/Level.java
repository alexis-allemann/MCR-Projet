package model.levels;

import model.components.IDecoratorFactory;
import model.components.fighters.Fighter;
import model.components.fighters.IFighter;
import model.components.fighters.Monster;
import model.components.fighters.decorators.FighterDecorator;
import model.components.fighters.decorators.MultipleShoot;
import model.components.fighters.decorators.Shield;
import model.components.fighters.decorators.SpeedBoost;
import model.components.weapon.decorators.BulletSizeEnhancer;
import model.components.weapon.decorators.ReloadSpeedEnhancer;
import model.components.weapon.decorators.ShootSpeedEnhancer;
import model.components.weapon.decorators.WeaponDecorator;
import utils.Utils;
import utils.physics.Location;

import java.util.List;

/**
 * Space invaders game model.levels
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Level implements IDecoratorFactory {
    protected int score;
    protected int nbMonstersKilled;
    private final long START;

    /**
     * Instantiation of a new level (Beginner by default)
     */
    public Level() {
        START = System.currentTimeMillis();
    }

    /**
     * Instantiation of a new level
     *
     * @param oldLevel to retrieve old attributes
     */
    public Level(Level oldLevel) {
        score = oldLevel.score;
        nbMonstersKilled = oldLevel.nbMonstersKilled;
        START = oldLevel.START;
    }

    /**
     * Check if level has changed
     */
    public abstract void checkLevelChanged();

    /**
     * define number of monsters
     *
     * @return number of monsters for each wave
     */
    public abstract int getNbMonsterByWave();

    /**
     * Generate a new monster
     *
     * @param location Location where the monster should spawn
     * @return generated monster
     */
    public IFighter generateMonster(Location location) {
        IFighter newMonster = new Monster(location, getMonsterShootTiming());

        float random = Utils.getInstance().randomFloat(1);
        if (random < getProbabilityOfMonstersToHaveDecorator()) {
            float shouldGenerateWeaponDecoration = Utils.getInstance().randomFloat(1);
            if (shouldGenerateWeaponDecoration < 0.5)
                newMonster.setWeapon(createWeaponDecorator(newMonster.getWeapon()));
            else
                newMonster = createFighterDecorator(newMonster);
        }

        return newMonster;
    }

    /**
     * Get probability to generate a decoration when a monster dies
     *
     * @return probability to generate a decoration when a monster dies
     */
    public abstract float probabilityToGenerateDecoration();

    public WeaponDecorator getWeaponDecoration(final model.components.weapon.Weapon weapon) {
        ArrayList<WeaponDecorator> list = new ArrayList<WeaponDecorator>() {{
//            add(new BulletSizeEnhancer(weapon, 2));
//            add(new BulletSizeEnhancer(weapon, 1.5f));
//            add(new BulletSizeEnhancer(weapon, 2.5f));
//            add(new ShootSpeedEnhancer(weapon, 2));
//            add(new ShootSpeedEnhancer(weapon, 1.5f));
//            add(new ShootSpeedEnhancer(weapon, 2.5f));
            add(new ReloadSpeedEnhancer(weapon, 0.2f));
            add(new ReloadSpeedEnhancer(weapon, 0.3f));
            add(new ReloadSpeedEnhancer(weapon, 0.5f));
        }};

        int index = Utils.getInstance().randomInt(list.size() - 1);
        return list.get(index);
    }

    public FighterDecorator getFighterDecoration(final Fighter fighter) {
        ArrayList<FighterDecorator> list = new ArrayList<FighterDecorator>() {{
            add(new MultipleShoot(fighter, 2));
            add(new Shield(fighter, 2));
            add(new SpeedBoost(fighter, 2, 0));
        }};

        int index = Utils.getInstance().randomInt(list.size() - 1);
        return list.get(index);
    }


    /**
     * Notify the level that a new monster has been killed
     */
    public void addMonsterKilled() {
        nbMonstersKilled++;
    }

    /**
     * Get the time up
     *
     * @return time in seconds
     */
    public int getTime() {
        long current = System.currentTimeMillis();
        return (int) (START - current) / 1000;
    }

    /**
     * Get current score
     *
     * @return current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Add point to the score
     *
     * @param points points to add
     */
    public void addScore(int points) {
        score += points;
    }

    /**
     * Get list of fighters decorators available
     *
     * @param fighter to decorate
     * @return list of fighters decorators
     */
    abstract List<FighterDecorator> getFighterDecorators(final IFighter fighter);

    /**
     * Get list of weapon decorators available
     *
     * @param weapon to decorate
     * @return list of weapon decorators
     */
    abstract List<WeaponDecorator> getWeaponDecorators(final IWeapon weapon);

    /**
     * Get monster timing for shoots
     *
     * @return the timing ratio between shoots
     */
    abstract float getMonsterShootTiming();

    /**
     * Get probability to get a decorated monster
     *
     * @return probability to get a decorated monster
     */
    abstract float getProbabilityOfMonstersToHaveDecorator();

    @Override
    public FighterDecorator createFighterDecorator(IFighter fighter) {
        return Utils.getInstance().chooseRandom(getFighterDecorators(fighter));
    }

    @Override
    public WeaponDecorator createWeaponDecorator(IWeapon weapon) {
        return Utils.getInstance().chooseRandom(getWeaponDecorators(weapon));
    }
}
