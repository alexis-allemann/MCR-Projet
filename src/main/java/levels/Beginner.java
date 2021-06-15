package levels;

import model.World;
import model.components.fighters.Fighter;
import model.components.fighters.Monster;
import model.components.physics.Location;

/**
 * Beginner level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Beginner extends Level {

    @Override
    public void checkLevelChanged() {
        if(nbMonstersKilled >= 2 || getTime() > 20)
            World.getInstance().setLevel(new Easy(this));
    }

    @Override
    public Fighter generateMonster(Location location) {
        return new Monster(location);
    }

    @Override
    public int getNbMonsterByWave() {
        return 4;
    }

    @Override
    public String toString() {
        return "Beginner";
    }
}
