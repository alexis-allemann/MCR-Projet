import controllers.GamePlay;
import views.GUIView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
        // TODO: est-ce que on vire les argument de main() ? -> il m'avait retiré des points pour ca en poo2
        try (InputStream input = SpaceInvaders.class.getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            Properties prop = new Properties();
            prop.load(input);
            GamePlay.getInstance().start(new GUIView(), prop);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}