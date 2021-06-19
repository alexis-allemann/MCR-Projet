package model.levels;

import model.World;
import utils.Utils;

/**
 * Hard level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Hard extends Level {
    private static final float MONSTER_SHOOT_TIMING = Float.parseFloat(Utils.getInstance().getProperty("LEVEL_3_MONSTER_SHOOT_TIMING"));
    private static final int NB_MONSTER_BY_WAVE = Integer.parseInt(Utils.getInstance().getProperty("LEVEL_3_NB_MONSTER_BY_WAVE"));
    private static final int NB_MONSTER_TO_KILL = Integer.parseInt(Utils.getInstance().getProperty("LEVEL_3_NB_MONSTER_TO_KILL"));
    private static final float PROB_TO_GET_DECORATION = Float.parseFloat(Utils.getInstance().getProperty("LEVEL_3_PROB_TO_GET_DECORATION"));
    private static final float PROB_DECORATED_MONSTER = Float.parseFloat(Utils.getInstance().getProperty("LEVEL_3_PROB_DECORATED_MONSTER"));
    private static final int TIME = Integer.parseInt(Utils.getInstance().getProperty("LEVEL_3_TIME"));

    /**
     * Change level to hard
     *
     * @param oldLevel to retrieve attributes
     */
    public Hard(Level oldLevel) {
        super(oldLevel);
    }

    @Override
    public void checkLevelChanged() {
        if (nbMonstersKilled >= NB_MONSTER_TO_KILL || getTimeInSeconds() > TIME)
            World.getInstance().setLevel(new Expert(this));
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
        return "Hard";
    }
}
