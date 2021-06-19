package model.levels;

import model.World;
import utils.Utils;

/**
 * Medium level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Medium extends Level {
    private static final float MONSTER_SHOOT_TIMING = Float.parseFloat(Utils.getInstance().getProperty("LEVEL_2_MONSTER_SHOOT_TIMING"));
    private static final int NB_MONSTER_BY_WAVE = Integer.parseInt(Utils.getInstance().getProperty("LEVEL_2_NB_MONSTER_BY_WAVE"));
    private static final int NB_MONSTER_TO_KILL = Integer.parseInt(Utils.getInstance().getProperty("LEVEL_2_NB_MONSTER_TO_KILL"));
    private static final float PROB_TO_GET_DECORATION = Float.parseFloat(Utils.getInstance().getProperty("LEVEL_2_PROB_TO_GET_DECORATION"));
    private static final float PROB_DECORATED_MONSTER = Float.parseFloat(Utils.getInstance().getProperty("LEVEL_2_PROB_DECORATED_MONSTER"));
    private static final int TIME = Integer.parseInt(Utils.getInstance().getProperty("LEVEL_2_TIME"));

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
        if (nbMonstersKilled >= NB_MONSTER_TO_KILL || getTimeInSeconds() > TIME)
            World.getInstance().setLevel(new Hard(this));
    }

    @Override
    public float probabilityToGenerateDecoration() {
        return PROB_TO_GET_DECORATION;
    }

    @Override
    public float getMonsterShootTiming() {
        return MONSTER_SHOOT_TIMING;
    }

    @Override
    public float getProbabilityOfMonstersToBeDecorated() {
        return PROB_DECORATED_MONSTER;
    }

    @Override
    public int getNbMonsterByWave() {
        return NB_MONSTER_BY_WAVE;
    }

    @Override
    String getMonsterImageName() {
        return "monster-blue.png";
    }

    @Override
    public String toString() {
        return "Medium";
    }
}
