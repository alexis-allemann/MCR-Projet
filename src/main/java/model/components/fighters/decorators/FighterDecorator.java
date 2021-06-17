package model.components.fighters.decorators;

import model.components.IGameComponentWithHitBox;
import model.components.fighters.IFighter;
import controllers.Direction;
import model.components.weapon.IWeapon;
import model.components.weapon.Weapon;
import utils.physics.Location;
import utils.physics.Vector2D;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Image;

/**
 * Space invaders model.components.fighters decorators
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class FighterDecorator implements IFighter {
    protected IFighter fighter;

    /**
     * Instantiation of a new decoration
     *
     * @param fighter to decorate
     */
    public FighterDecorator(IFighter fighter) {
        this.fighter = fighter;
    }

    @Override
    public Direction getDirection() {
        return fighter.getDirection();
    }

    @Override
    public int getDefaultHealth() {
        return fighter.getDefaultHealth();
    }

    @Override
    public boolean isMonsterTeam() {
        return fighter.isMonsterTeam();
    }

    @Override
    public float getNextTimingModifier() {
        return fighter.getNextTimingModifier();
    }

    @Override
    public Location getLocation() {
        return fighter.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        fighter.setLocation(location);
    }

    @Override
    public IWeapon getWeapon() {
        return fighter.getWeapon();
    }

    @Override
    public void setWeapon(IWeapon weapon) {
        fighter.setWeapon(weapon);
    }

    @Override
    public Vector2D getSpeed() {
        return fighter.getSpeed();
    }

    @Override
    public void setSpeed(Vector2D speed) {
        fighter.setSpeed(speed);
    }

    @Override
    public void shoot() {
        fighter.shoot();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        fighter.draw(graphics2D);
    }

    @Override
    public int getHealth() {
        return fighter.getHealth();
    }

    @Override
    public void removeHealth(int hp) {
        fighter.removeHealth(hp);
    }

    @Override
    public boolean alive() {
        return fighter.alive();
    }

    @Override
    public void die() {
        fighter.die();
    }

    @Override
    public int getPoints() {
        return fighter.getPoints();
    }

    @Override
    public boolean checkHitBox(Vector2D speed, IGameComponentWithHitBox other) {
        return fighter.checkHitBox(speed, other);
    }

    @Override
    public Rectangle getHitBoxLocation() {
        return fighter.getHitBoxLocation();
    }

    @Override
    public final boolean isInBounds() {
        return fighter.isInBounds();
    }

    @Override
    public Image getImage() {
        return fighter.getImage();
    }

    @Override
    public int getImageWidth() {
        return fighter.getImageWidth();
    }

    @Override
    public int getImageHeight() {
        return fighter.getImageHeight();
    }

    @Override
    public final IFighter removeDecorator(FighterDecorator decorator) {
        if (this == decorator) {
            return fighter;
        } else {
            fighter = fighter.removeDecorator(decorator);
        }
        return this;
    }

    @Override
    public void move() {
        fighter.move();
    }
}
