package levels;

import components.fighters.Fighter;

/**
 * Beginner level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Beginner extends Level {
    @Override
    public int getMonstersSpeed() {
        return 0;
    }

    @Override
    public Fighter generateMonster() {
        return null;
    }

    @Override
    public void checkLevelChanged() {
        if()
    }
}
