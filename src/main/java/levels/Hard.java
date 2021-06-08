package levels;

import components.fighters.Fighter;

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
    public Fighter generateMonster() {
        //TODO use FighterManager.getInstance().addMonster(%newly created monster%)
        return null;
    }

    @Override
    public void checkLevelChanged() {
        if (nbMonstersKilled > 30 || getTime() > 120)
            new Expert(this);
    }

    @Override
    public int getNbMonsterByWave() {
        return 40;
    }
}
