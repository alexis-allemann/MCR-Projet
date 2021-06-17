package model.levels;

import model.World;
import model.components.fighters.Fighter;
import model.components.fighters.Monster;
import utils.physics.Location;

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
    public void checkLevelChanged() {
        if (nbMonstersKilled >= 5 || getTime() > 40)
            World.getInstance().setLevel(new Medium(this));
    }

    @Override
    public Fighter generateMonster(Location location) {
        // TODO : ajout d'un décorateur
        return new Monster(location, 1.4f);
    }

    @Override
    public float probabilityToGenerateDecoration() {
        return 0.2f;
    }

    @Override
    public int getNbMonsterByWave() {
        return 5;
    }

    @Override
    public String toString() {
        return "Easy";
    }
}
