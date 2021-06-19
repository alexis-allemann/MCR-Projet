package model.components.fighters;

import model.World;
import model.components.weapon.Projectile;
import utils.Utils;
import utils.physics.Location;
import controllers.Direction;
import model.components.weapon.BombWeapon;
import utils.physics.Vector2D;

import java.util.List;

/**
 * Monsters used to fight against space craft
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Monster extends Fighter {
    private static final int POINTS_MONSTER = 50;
    private static final int SECONDS_BEFORE_DOWN_MOVE = 2;
    private long lastMonstersDownMove = System.currentTimeMillis();
    private final float timingRange;

    /**
     * Instantiation of a new monster
     *
     * @param location          where monster is located
     * @param maxTimingModifier timing modifier to shoot a new bullet
     * @param imageName         name of the monster image
     */
    public Monster(Location location, float maxTimingModifier, String imageName) {
        super(location, imageName);
        setWeapon(new BombWeapon());
        this.timingRange = maxTimingModifier;
    }

    @Override
    public Direction getDirection() {
        return Direction.DOWN;
    }

    @Override
    public int getDefaultHealth() {
        return 10;
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
    public int getPoints() {
        return POINTS_MONSTER;
    }

    @Override
    public void die() {
        final World world = World.getInstance();
        world.removeMonster(this);
        world.getLevel().addScore(getPoints());
        float random = Utils.getInstance().randomFloat(1);
        if (random <= world.getLevel().probabilityToGenerateDecoration()) {
            world.addBullet(new Projectile(new Location(super.location), "star.png", new Vector2D(0, 5), true) {

                @Override
                public void hit(IFighter fighter) {
                    if (fighter.canBeDecorated()) {
                        float shouldGenerateWeaponDecoration = Utils.getInstance().randomFloat(1);
                        if (shouldGenerateWeaponDecoration < 0.5)
                            fighter.setWeapon(world.getLevel().createWeaponDecorator(fighter.getWeapon()));
                        else
                            world.setSpacecraft(world.getLevel().createFighterDecorator(fighter));
                    }
                }
            });
        }
    }

    @Override
    public void setNextSpeed() {
        List<IFighter> monsters = World.getInstance().getMonsters();
        int index = monsters.indexOf(this);

        boolean invertSpeed = false;
        Vector2D nullSpeed = new Vector2D(0.f, 0.f);
        if (
                (index != 0 && checkHitBox(nullSpeed, monsters.get(index - 1))) ||
                        (index != monsters.size() - 1 && checkHitBox(nullSpeed, monsters.get(index + 1))) ||
                        !isInBounds()
        )
            invertSpeed = true;


        // Calculate speed on X axis
        int speedOnX = (int) this.speed.getX();
        if (invertSpeed)
            speedOnX *= -1;

        setSpeed(speedOnX, (int) getDownMove());
    }

    /**
     * Get down move
     *
     * @return move on Y axis
     */
    private float getDownMove() {
        boolean downMove = System.currentTimeMillis() - lastMonstersDownMove > SECONDS_BEFORE_DOWN_MOVE * 1000;
        if (downMove) {
            lastMonstersDownMove = System.currentTimeMillis();
            return 10.0f;
        } else
            return 0.f;
    }
}
