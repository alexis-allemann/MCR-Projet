package levels;

import components.fighters.Fighter;
import components.fighters.Monster;
import components.physics.Location;
import controllers.Direction;
import controllers.gameplay.FighterManager;

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
    public Fighter generateMonster(Location location){
        // TODO : ajout d'un décorateur
        return new Monster(location);
    }

    @Override
    public void checkLevelChanged() {
        if(nbMonstersKilled > 5 || getTime() > 40)
            new Medium(this);
    }

    @Override
    public int getNbMonsterByWave() {
        return 20;
    }
}
