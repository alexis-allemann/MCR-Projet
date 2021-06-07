package levels;

import components.fighters.Fighter;

/**
 * Space invaders game levels
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Level {
    private int score;
    private int nbMonstersKilled;
    // Tem

    /**
     *
     * @param oldLevel
     */
    public Level(Level oldLevel) {
        score = oldLevel.score;
        nbMonstersKilled = oldLevel.nbMonstersKilled;
    }

    /**
     * Get monsters speed
     *
     * @return speed of the monsters
     */
    public abstract int getMonstersSpeed();

    /**
     * Generate a new monster
     *
     * @return generated
     */
    public abstract Fighter generateMonster();

    /**
     * Check if level has changed
     */
    public abstract void checkLevelChanged();
}
