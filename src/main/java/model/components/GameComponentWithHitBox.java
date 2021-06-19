package model.components;

import controllers.GameController;
import utils.physics.Location;
import utils.physics.Speed;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * Displayable game component with a hit box
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class GameComponentWithHitBox extends GameComponent implements IGameComponentWithHitBox {
    protected Speed speed;

    /**
     * Instantiation of a new game component with a hit box
     *
     * @param location where component is
     * @param imageName of the component image
     */
    public GameComponentWithHitBox(Location location, String imageName) {
        super(location, imageName);
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
        return new Rectangle((int) getLocation().getFloatX(), (int) getLocation().getFloatY(), getImageWidth(), getImageHeight());
    }

    @Override
    public boolean checkHitBox(Speed speed, IGameComponentWithHitBox other) {
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
        return location.getFloatX() + getImageWidth() <= GameController.WIDTH &&
                location.getFloatY() + getImageHeight() <= GameController.WIDTH &&
                location.getFloatX() >= 0 &&
                location.getFloatY() >= 0;
    }

    @Override
    public void move() {
        location.translate(speed.getX(), speed.getY());
    }

    @Override
    public Speed getSpeed() {
        return speed;
    }

    @Override
    public void calculateAndSetNextSpeed() {
    }

    @Override
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    @Override
    public void setSpeed(int speedOnX, int speedOnY) {
        this.speed = new Speed(speedOnX, speedOnY);
    }
}
