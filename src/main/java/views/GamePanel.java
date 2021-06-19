package views;

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;

/**
 * GamePanel displaying all game components
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class GamePanel extends JPanel {
    private Image gameImage;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gameImage, 0, 0, null);
    }

    /**
     * Set the image of the game panel
     *
     * @param gameImage image of the game panel
     */
    public void setGameImage(Image gameImage) {
        this.gameImage = gameImage;
    }
}
