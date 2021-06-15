package levels;

import model.components.fighters.Fighter;
import model.components.physics.Location;

/**
 * Space invaders game levels
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Level {
    int score;
    int nbMonstersKilled;
    long start;

    /**
     * Instantiation of a new level (Beginner by default)
     */
    public Level() {
        start = System.currentTimeMillis();
    }

    /**
     * Instantiation of a new level
     *
     * @param oldLevel to retrieve old attributes
     */
    public Level(Level oldLevel) {
        score = oldLevel.score;
        nbMonstersKilled = oldLevel.nbMonstersKilled;
        start = oldLevel.start;
    }

    /**
     * Notify the level that a new monster has been killed
     */
    public void addMonsterKilled() {
        nbMonstersKilled++;
    }

    /**
     * Generate a new monster
     *
     * @param location Location where the monster should spawn
     * @return generated monster
     */
    public abstract Fighter generateMonster(Location location);

    /**
     * Check if level has changed
     */
    public abstract void checkLevelChanged();

    /**
     * Get the time up
     *
     * @return time in seconds
     */
    public int getTime() {
        long current = System.currentTimeMillis();
        return (int) (start - current) / 1000;
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
     * define number of monsters
     *
     * @return number of monsters for each wave
     */
    public abstract int getNbMonsterByWave();
}
