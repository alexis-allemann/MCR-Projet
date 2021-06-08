package levels;

import components.fighters.GameComponent;

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
    public GameComponent generateMonster() {
        return null;
    }

    @Override
    public void checkLevelChanged() {
        if (nbMonstersKilled > 15 || getTime() > 90)
            new Hard(this);
    }
}
