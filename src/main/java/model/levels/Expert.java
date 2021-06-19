package model.levels;

import utils.Utils;

/**
 * Expert level
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Expert extends Level {
    private static final int MONSTER_HIT_POINTS = Integer.parseInt(Utils.getInstance().getProperty("LEVEL_4_MONSTER_HIT_POINTS"));
    private static final float MONSTER_SHOOT_TIMING = Float.parseFloat(Utils.getInstance().getProperty("LEVEL_4_MONSTER_SHOOT_TIMING"));
    private static final int NB_MONSTER_BY_WAVE = Integer.parseInt(Utils.getInstance().getProperty("LEVEL_4_NB_MONSTER_BY_WAVE"));
    private static final float PROB_TO_GET_DECORATION = Float.parseFloat(Utils.getInstance().getProperty("LEVEL_4_PROB_TO_GET_DECORATION"));
    private static final float PROB_DECORATED_MONSTER = Float.parseFloat(Utils.getInstance().getProperty("LEVEL_4_PROB_DECORATED_MONSTER"));

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
    public float getMonsterShootTiming() {
        return MONSTER_SHOOT_TIMING;
    }

    @Override
    public float getProbabilityOfMonstersToBeDecorated() {
        return PROB_DECORATED_MONSTER;
    }

    @Override
    public float probabilityToGenerateDecoration() {
        return PROB_TO_GET_DECORATION;
    }

    @Override
    public int getNbMonsterByWave() {
        return NB_MONSTER_BY_WAVE;
    }

    @Override
    int getMonsterDefaultHealthPoints() {
        return MONSTER_HIT_POINTS;
    }

    @Override
    String getMonsterImageName() {
        return "monster-pink.png";
    }

    @Override
    public String toString() {
        return "Expert";
    }
}
