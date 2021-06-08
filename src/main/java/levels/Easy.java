package levels;

import components.fighters.Fighter;

/**
 * Easy level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Easy extends Level {

    /**
     * Change level to easy
     *
     * @param oldLevel to retrieve attributes
     */
    public Easy(Level oldLevel) {
        super(oldLevel);
    }

    @Override
    public Fighter generateMonster() {

        //TODO use FighterManager.getInstance().addMonster(%newly created monster%)
        return null;
    }

    @Override
    public void checkLevelChanged() {
        if(nbMonstersKilled > 5 || getTime() > 40)
            new Medium(this);
    }

    @Override
    public int getNbMonsterByWave() {
        return 20;
    }
}
