import controllers.GameController;
import views.GUIView;

/**
 * Main application class
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpaceInvaders {

    /**
     * Main application method
     *
     * @param args no args required
     */
    public static void main(String[] args) {
        GameController.getInstance().start(new GUIView());
    }
}