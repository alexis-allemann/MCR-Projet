package views;

import controllers.IController;

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
     * @param IController to manage gameplay
     */
    void startView(IController IController);

    /**
     * Repaint the view with the image
     *
     * @param image the image to paint
     */
    void paintImage(Image image);

    /**
     * Return an empty image of the view
     *
     * @return an empty image with the right size
     */
    Image getBufferedImage();
}
