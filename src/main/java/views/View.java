package views;

import components.bullets.Bullet;
import controllers.Controller;
import components.fighters.GameComponent;

/**
 * Space invaders view to display gameplay
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface View {

    /**
     * Start the view
     *
     * @param controller to manage gameplay
     */
    void startView(Controller controller);

    /**
     * Display a new message
     *
     * @param message to display
     */
    void displayMessage(String message);

    /**
     * Paint a component on the view at a given position
     *
     * @param component to paint
     */
    void paintComponent(GameComponent component);

    /**
     * Remove a component on the view at a given position
     *
     * @param component to remove
     */
    void removeComponent(GameComponent component);
}
