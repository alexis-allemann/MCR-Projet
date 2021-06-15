package model.components;

import controllers.GamePlay;
import model.components.physics.Location;
import model.components.physics.Vector2D;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameComponentWithHitBox extends GameComponent {

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

    /**
     * Get hit box location on screen
     *
     * @return hit box location on screen
     */
    public Rectangle getHitBoxLocation() {
        return new Rectangle((int) getLocation().x, (int) getLocation().y, getImageWidth(), getImageHeight());
    }

    /**
     * Check if component has been touched
     *
     * @param speed of the component
     * @param other other component to check collision
     * @return if component has been touched
     */
    public boolean checkHitBox(Vector2D speed, GameComponentWithHitBox other) {
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

    /**
     * Check if a location of a fighter is in view bounds
     *
     * @return boolean if it is in bounds
     */
    public boolean isInBounds() {
        return location.x + getImageWidth() <= GamePlay.WIDTH &&
                location.y + getImageHeight() <= GamePlay.WIDTH &&
                location.x >= 0 &&
                location.y >= 0;
    }
}
