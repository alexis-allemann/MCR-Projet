package controllers;

import views.View;

import java.util.Properties;

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
     * @param view       to start gameplay into
     * @param properties used in the game
     * @throws IllegalArgumentException if the view is null
     */
    void start(View view, Properties properties);

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

    /**
     * Know if the game is running
     *
     * @return boolean if the game is running
     */
    boolean isRunning();
}
