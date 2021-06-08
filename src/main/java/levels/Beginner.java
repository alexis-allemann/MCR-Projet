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
    public Fighter generateMonster() {
        //TODO use FighterManager.getInstance().addMonster(%newly created monster%)
        return null;
    }

    @Override
    public void checkLevelChanged() {
        if(nbMonstersKilled > 2 || getTime() > 20)
            new Easy(this);
    }

    @Override
    public int getNbMonsterByWave() {
        return 10;
    }
}
