package levels;

import components.fighters.Fighter;
import components.fighters.Monster;
import components.physics.Location;

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
    public Fighter generateMonster(Location location) {
        // TODO : ajout d'un décorateur
        return new Monster(location);
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
