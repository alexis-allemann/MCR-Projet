package controllers;

import views.View;

/**
 * Space invaders controller to manage gameplay
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface Controller {

    /**
     * Start the gameplay in a new view
     *
     * @param view to start gameplay into
     * @throws IllegalArgumentException if the view is null
     */
    void start(View view);

    /**
     * Start a new game
     */
    void newGame();

    /**
     * Shoot a new bullet
     */
    void shoot();

    /**
     * Move fighters.spacecraft
     *
     * @param direction where to move
     */
    void move(MoveDirection direction);
}
