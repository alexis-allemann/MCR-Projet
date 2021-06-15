package levels;

import model.components.fighters.Fighter;
import model.components.fighters.Monster;
import model.components.physics.Location;

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
    public void checkLevelChanged() {
    }

    @Override
    public Fighter generateMonster(Location location) {
        // TODO : ajout d'un décorateur
        return new Monster(location);
    }

    @Override
    public int getNbMonsterByWave() {
        return 8;
    }

    @Override
    public String toString() {
        return "Expert";
    }
}
