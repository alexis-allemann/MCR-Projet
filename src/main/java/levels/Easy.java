package levels;

import components.fighters.GameComponent;

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
    public GameComponent generateMonster() {
        return null;
    }

    @Override
    public void checkLevelChanged() {
        if(nbMonstersKilled > 5 || getTime() > 40)
            new Medium(this);
    }
}
