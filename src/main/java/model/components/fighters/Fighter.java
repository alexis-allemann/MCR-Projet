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
    private static final Speed BASE_SPEED = new Speed(1.f, 0.f);
    private static int nb;
    private final int ID = nb++;
    private IWeapon weapon;
    private int health;

    /**
     * Instantiation of a new fighter
     *
     * @param location      where fighter is located
     * @param defaultHealth default health of the fighter
     * @param imageName     filename of the fighter to display
     */
    public Fighter(Location location, int defaultHealth, String imageName) {
        super(location, imageName);
        speed = BASE_SPEED;
        health = defaultHealth;
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
        return ID;
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
    public void removeHealth(int hp) {
        health -= hp;
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
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
    public boolean canBeDecorated() {
        return countDecorator() + getWeapon().countDecorator() < MAX_COUNT;
    }

    @Override
    public IFighter removeDecorator(FighterDecorator decorator) {
        return this;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        IFighter fighter = (IFighter) o;
        return ID == fighter.getId();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        getWeapon().draw(graphics2D);
    }
}
