package levels;

import components.fighters.Fighter;

/**
 * Medium level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Medium extends Level {

    public Medium(Level oldLevel) {
        super(oldLevel);
    }

    @Override
    public Fighter generateMonster() {
        //TODO use FighterManager.getInstance().addMonster(%newly created monster%)
        return null;
    }

    @Override
    public void checkLevelChanged() {
        if (nbMonstersKilled > 15 || getTime() > 90)
            new Hard(this);
    }

    @Override
    public int getNbMonsterByWave() {
        return 30;
    }
}
