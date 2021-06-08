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
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream input = classloader.getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);
            GamePlay.getInstance().start(new GUIView(), prop);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}