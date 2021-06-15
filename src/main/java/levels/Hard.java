package levels;

import model.World;
import model.components.fighters.Fighter;
import model.components.fighters.Monster;
import model.components.physics.Location;

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
    public Fighter generateMonster(Location location) {
        // TODO : ajout d'un décorateur
        return new Monster(location);
    }

    @Override
    public void checkLevelChanged() {
        if (nbMonstersKilled >= 30 || getTime() > 120)
            World.getInstance().setLevel(new Expert(this));
    }

    @Override
    public int getNbMonsterByWave() {
        return 7;
    }

    @Override
    public String toString() {
        return "Hard";
    }
}
