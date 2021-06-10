package levels;

import components.fighters.Fighter;
import components.fighters.Monster;
import components.physics.Location;

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
    public Fighter generateMonster(Location location) {
        // TODO : ajout d'un décorateur
        return new Monster(location);
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
