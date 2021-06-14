package model.components;

import controllers.GamePlay;
import model.components.fighters.Fighter;
import model.components.physics.Location;
import model.components.physics.Vector2D;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameComponentWithHitbox extends GameComponent {
    protected int hitboxSize = 20;

    /**
     * Instantiation of a new game component with a hitbox
     *
     * @param location where component is
     * @param filename of the component image
     */
    public GameComponentWithHitbox(Location location, String filename) {
        super(location, filename);
    }

    /**
     * Instantiation of a new game component
     *
     * @param location where component is located
     * @param image    image to display
     */
    public GameComponentWithHitbox(Location location, Image image) {
        super(location, image);
    }

    /**
     * Get hitbox location on screen
     *
     * @return hitbox location on screen
     */
    public Rectangle getHitBoxLocation() {
        int x1 = (int) (getLocation().x + (getImageWidth() / 2.f) - hitboxSize/2);
        int y1 = (int)(getLocation().y + (getImageHeight() / 2.f) - hitboxSize/2);
        return new Rectangle(x1, y1, hitboxSize, hitboxSize);
    }

    /**
     * Check if component has been touched
     *
     * @param speed of the component
     * @param other other component to check colision
     * @return if component has been touched
     */
    public boolean checkHitbox(Vector2D speed, GameComponentWithHitbox other) {
        Rectangle otherHitbox = other.getHitBoxLocation();
        Rectangle hitboxWithMovement = getHitBoxLocation();
        int xSpeed = (int) speed.getX();
        int ySpeed = (int) speed.getY();
        int xAbsolutSpeed = Math.abs(xSpeed);
        int yAbsolutSpeed = Math.abs(ySpeed);
        hitboxWithMovement.grow(xAbsolutSpeed, yAbsolutSpeed);
        if(xSpeed < 0){
            hitboxWithMovement.translate(xSpeed, 0);
        }
        if(ySpeed < 0){
            hitboxWithMovement.translate(0, ySpeed);
        }
        Rectangle intersection = hitboxWithMovement.intersection(otherHitbox);
        return !intersection.isEmpty();
    }

    /**
     * Check if component has been touched
     *
     * @param other other component to check colision
     * @return if component has been touched
     */
    public boolean checkHitbox(GameComponentWithHitbox other) {
        return checkHitbox(new Vector2D(0,0), other);
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
