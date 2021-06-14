package views;

import controllers.Controller;
import java.awt.Image;

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
     * Repaint the view with the image
     * @param image the image to paint
     */
    public void paintImage(Image image);

    /**
     * Return an empty image of the view
     * @return an empty image with the right size
     */
    public Image getBufferedImage();
}
