package levels;

import components.fighters.Fighter;

/**
 * Expert level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Expert extends Level{

    /**
     * Change level to expert
     *
     * @param oldLevel to retrieve attributes
     */
    public Expert(Level oldLevel) {
        super(oldLevel);
    }

    @Override
    public Fighter generateMonster() {
        //TODO use FighterManager.getInstance().addMonster(%newly created monster%)
        return null;
    }

    @Override
    public void checkLevelChanged() {
        return;
    }

    @Override
    public int getNbMonsterByWave() {
        return 50;
    }
}
