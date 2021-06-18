package model.components;

import controllers.GamePlay;
import utils.physics.Location;
import utils.physics.Vector2D;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * Displayable game component with a hitbox
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class GameComponentWithHitBox extends GameComponent implements IGameComponentWithHitBox  {
    protected Vector2D speed;

    /**
     * Instantiation of a new game component with a hit box
     *
     * @param location where component is
     * @param filename of the component image
     */
    public GameComponentWithHitBox(Location location, String filename) {
        super(location, filename);
    }

    /**
     * Instantiation of a new game component
     *
     * @param location where component is located
     * @param image    image to display
     */
    public GameComponentWithHitBox(Location location, Image image) {
        super(location, image);
    }

    @Override
    public Rectangle getHitBoxLocation() {
        return new Rectangle((int) getLocation().x, (int) getLocation().y, getImageWidth(), getImageHeight());
    }

    @Override
    public boolean checkHitBox(Vector2D speed, IGameComponentWithHitBox other) {
        Rectangle otherHitBox = other.getHitBoxLocation();
        Rectangle hitBoxWithMovement = getHitBoxLocation();
        int xSpeed = (int) speed.getX();
        int ySpeed = (int) speed.getY();
        int xAbsolutSpeed = Math.abs(xSpeed);
        int yAbsolutSpeed = Math.abs(ySpeed);
        hitBoxWithMovement.grow(xAbsolutSpeed, yAbsolutSpeed);
        if (xSpeed < 0)
            hitBoxWithMovement.translate(xSpeed, 0);

        if (ySpeed < 0)
            hitBoxWithMovement.translate(0, ySpeed);

        Rectangle intersection = hitBoxWithMovement.intersection(otherHitBox);
        return !intersection.isEmpty();
    }

    @Override
    public boolean isInBounds() {
        return location.x + getImageWidth() <= GamePlay.WIDTH &&
                location.y + getImageHeight() <= GamePlay.WIDTH &&
                location.x >= 0 &&
                location.y >= 0;
    }

    @Override
    public Vector2D getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(Vector2D speed) {
        this.speed = speed;
    }

    @Override
    public void move() {
        move(getSpeed());
    }

    @Override
    public void move(Vector2D speed){
        location.translate(speed.getX(), speed.getY());
    }

    @Override
    public void setNextSpeed() {
        return;
    }
}
