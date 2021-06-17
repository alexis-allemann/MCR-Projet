package model.components;

import utils.physics.Vector2D;

import java.awt.Rectangle;

/**
 * Fighter interface
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface IGameComponentWithHitBox extends IGameComponent{

    /**
     * Method to know if a fighter is a monster
     *
     * @return if the fighter is a monster
     */
    boolean isMonsterTeam();

    /**
     * Get hit box location on screen
     *
     * @return hit box location on screen
     */
    Rectangle getHitBoxLocation();

    /**
     * Check if component has been touched
     *
     * @param speed of the component
     * @param other other component to check collision
     * @return if component has been touched
     */
    boolean checkHitBox(Vector2D speed, IGameComponentWithHitBox other);

    /**
     * Check if a location of a fighter is in view bounds
     *
     * @return boolean if it is in bounds of the view
     */
    boolean isInBounds();
}
