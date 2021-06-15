package levels;

import model.World;
import model.components.fighters.Fighter;
import model.components.fighters.Monster;
import model.components.weapon.decorators.BulletSizeEnhancer;
import utils.physics.Location;
import model.components.weapon.LaserWeapon;

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
        Monster newMonster = new Monster(location, 1.5f);
        newMonster.setWeapon(new BulletSizeEnhancer(new LaserWeapon(), 3));
        return newMonster;
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
