package levels;

import fighters.Fighter;

public class Easy extends Level{
    @Override
    public int getMonstersSpeed() {
        return 0;
    }

    @Override
    public Fighter generateMonster() {
        return null;
    }

    @Override
    public void checkLevelChanged() {

    }
}
