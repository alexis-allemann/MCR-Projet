package views;

import bullets.Bullet;
import controllers.Controller;
import fighters.Fighter;

import java.awt.Point;

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
     * Paint a fighter on the view at a given position
     * @param fighter to paint
     */
    void paintFighter(Fighter fighter);

    void removeFighter(Fighter spacecraft);

    void removeBullet(Bullet bullet);

    void paintBullet(Bullet bullet);
}
