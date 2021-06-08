package levels;

import components.fighters.GameComponent;

/**
 * Beginner level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Beginner extends Level {

    @Override
    public GameComponent generateMonster() {
        return null;
    }

    @Override
    public void checkLevelChanged() {
        if(nbMonstersKilled > 2 || getTime() > 20)
            new Easy(this);
    }
}
