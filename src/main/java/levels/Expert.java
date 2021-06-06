package levels;

import components.fighters.Fighter;

/**
 * Expert level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Expert extends Level{
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

    }
}
