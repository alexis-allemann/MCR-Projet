package model.components.fighters;

import model.components.GameComponentWithHitBox;
import model.components.fighters.decorators.FighterDecorator;
import model.components.weapon.IWeapon;
import utils.Utils;
import utils.physics.Location;
import utils.physics.Speed;

import java.awt.Graphics2D;

/**
 * Space invaders fighter
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Fighter extends GameComponentWithHitBox implements IFighter {
    private static final int MAX_COUNT = Integer.parseInt(Utils.getInstance().getProperty("NB_MAX_DECORATIONS"));
    private static final Speed SPEED_BASE = new Speed(1.f, 0.f);
    private IWeapon weapon;
    private int health;
    private static int nb;
    private final int id = nb++;

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
    public int getId() {
        return id;
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
    public boolean isAlive() {
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
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public IFighter removeDecorator(FighterDecorator decorator) {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        IFighter fighter = (IFighter) o;
        return id == fighter.getId();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        getWeapon().draw(graphics2D);
    }

    @Override
    public int countDecorator(Class decoratorClass) {
        return 0;
    }

    @Override
    public int countDecorator() {
        return 0;
    }

    @Override
    public boolean canBeDecorated() {
        return countDecorator() + getWeapon().countDecorator() < MAX_COUNT;
    }
}
