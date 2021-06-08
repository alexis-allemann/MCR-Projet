package levels;

import components.fighters.Fighter;

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
     * Generate a new monster
     *
     * @return generated monster
     */
    public abstract Fighter generateMonster();

    /**
     * Check if level has changed
     */
    public abstract void checkLevelChanged();

    /**
     * Get the time up
     * @return time in seconds
     */
    public int getTime() {
        long current = System.currentTimeMillis();
        return (int) (start - current) / 1000;
    }

    /**
     * define number of monsters
     *
     * @return number of monsters for each wave
     */
    public abstract int getNbMonsterByWave();
}
