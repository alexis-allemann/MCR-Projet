package components;

import components.physics.Location;
import components.physics.Vector2D;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameComponentWithHitbox extends GameComponent {
    protected int hitboxSize;

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
    protected Rectangle getHitBoxLocation() {
        int x1 = (int) (getLocation().x + (getImageWidth() / 2.f));
        int x2 = x1 + hitboxSize;
        int y1 = (int)(getLocation().x + (getImageHeight() / 2.f));
        int y2 = y1 + hitboxSize;
        return new Rectangle(x1, y1, x2, y2);
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
        hitboxWithMovement.grow((int)speed.getX(), (int)speed.getY());
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
}
