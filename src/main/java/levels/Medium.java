package levels;

import model.World;
import model.components.fighters.Fighter;
import model.components.fighters.Monster;
import utils.physics.Location;

/**
 * Medium level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Medium extends Level {

    /**
     * Change level to medium
     *
     * @param oldLevel to retrieve attributes
     */
    public Medium(Level oldLevel) {
        super(oldLevel);
    }

    @Override
    public void checkLevelChanged() {
        if (nbMonstersKilled >= 15 || getTime() > 90)
            World.getInstance().setLevel(new Hard(this));
    }

    @Override
    public Fighter generateMonster(Location location) {
        // TODO : ajout d'un décorateur
        return new Monster(location, 1.3f);
    }

    @Override
    public int getNbMonsterByWave() {
        return 6;
    }

    @Override
    public String toString() {
        return "Medium";
    }
}
