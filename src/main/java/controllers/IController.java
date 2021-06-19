package controllers;

import utils.physics.Direction;
import views.IView;

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
     * @param IView to start gameplay into
     */
    void start(IView IView);

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
