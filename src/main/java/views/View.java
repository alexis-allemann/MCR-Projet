package views;

import controllers.Controller;

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
}
