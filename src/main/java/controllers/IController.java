package controllers;

import views.View;

import java.util.Properties;

/**
 * Space invaders controller to manage gameplay
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface IController {

    /**
     * Start the gameplay in a new view
     *
     * @param view       to start gameplay into
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
     * Move model.components.fighters.spacecraft
     *
     * @param direction where to move
     */
    void move(Direction direction);
}
