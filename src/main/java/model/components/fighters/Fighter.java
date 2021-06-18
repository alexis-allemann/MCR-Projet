package model.components.fighters;

import model.World;
import model.components.GameComponentWithHitBox;
import model.components.fighters.decorators.FighterDecorator;
import model.components.weapon.IWeapon;
import model.components.weapon.Projectile;
import model.components.weapon.Weapon;
import utils.Utils;
import utils.physics.Vector2D;
import utils.physics.Location;

import java.util.Objects;

/**
 * Space invaders fighter
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Fighter extends GameComponentWithHitBox implements IFighter {
    private static final Vector2D SPEED_BASE = new Vector2D(1.f, 0.f);
    private IWeapon weapon;
    private int health;

    /**
     * Instantiation of a new fighter
     *
     * @param location where fighter is located
     * @param image    filename of the fighter to display
     */
    public Fighter(Location location, String image) {
        super(location, image);
        speed = SPEED_BASE;
        health = getDefaultHealth();
    }

    /**
     * Instantiation of a new fighter
     *
     * @param fighter to encompass
     */
    public Fighter(Fighter fighter) {
        super(fighter.getLocation(), fighter.getImage());
        speed = fighter.speed;
        weapon = fighter.weapon;
        health = fighter.health;
    }

    @Override
    public IWeapon getWeapon() {
        return weapon;
    }

    @Override
    public void setWeapon(IWeapon weapon) {
        this.weapon = weapon;
        this.weapon.setFighter(this);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean alive() {
        return getHealth() > 0;
    }

    @Override
    public void removeHealth(int hp) {
        health -= hp;
    }

    @Override
    public void shoot() {
        if (getWeapon() != null) {
            getWeapon().shoot();
        }
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
                    float shouldGenerateWeaponDecoration = Utils.getInstance().randomFloat(1);
                    if(shouldGenerateWeaponDecoration < 0.5)
                        fighter.setWeapon(world.getLevel().createWeaponDecorator(fighter.getWeapon()));
                    else
                        world.setSpacecraft(world.getLevel().createFighterDecorator(fighter));
                }
            });
        }
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public Fighter removeDecorator(FighterDecorator decorator) {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        IFighter fighter = (IFighter) o;
        // TODO : voir si on peut améliorer la condition
        return health == fighter.getHealth() && Objects.equals(weapon, fighter.getWeapon());
    }
}
