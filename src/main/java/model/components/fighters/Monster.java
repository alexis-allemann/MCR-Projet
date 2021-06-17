package model.components.fighters;

import utils.Utils;
import utils.physics.Location;
import controllers.Direction;
import model.components.weapon.BombWeapon;
import utils.physics.Vector2D;

/**
 * Monsters used to fight against space craft
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Monster extends Fighter {
    private final float timingRange;
    private final int DOWN_SPEED_TICK = 30;
    private int down_speed_current_tick = 0;
    private final int POINTS_MONSTER = 50;

    /**
     * Instantiation of a new monster
     *
     * @param location          where monster is located
     * @param maxTimingModifier timing modifier to shoot a new bullet
     */
    public Monster(Location location, float maxTimingModifier) {
        super(location, "monster-green.png");
        setWeapon(new BombWeapon());
        this.timingRange = maxTimingModifier;
    }

    @Override
    public Direction getDirection() {
        return Direction.DOWN;
    }

    @Override
    public int getDefaultHealth() {
        return 1;
    }

    @Override
    public float getNextTimingModifier() {
        return Utils.getInstance().randomFloat(1, timingRange);
    }

    @Override
    public boolean isMonsterTeam() {
        return true;
    }

    @Override
    public void shoot() {
        float randomNumber = Utils.getInstance().randomFloat(1);
        if (randomNumber <= timingRange)
            super.shoot();
    }

    @Override
    public int getPoints() {
        return POINTS_MONSTER;
    }

    @Override
    public Vector2D getSpeed() {
        down_speed_current_tick++;
        if(down_speed_current_tick == DOWN_SPEED_TICK){
            down_speed_current_tick = 0;
            speed.setX(-speed.getX());
            return new Vector2D(0, 5f);
        } else {
            return speed;
        }
    }
}
