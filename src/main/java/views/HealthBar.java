package views;

import controllers.GameController;
import model.World;
import model.components.fighters.SpaceCraft;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Health bar of the game
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class HealthBar extends JPanel {
    private final JLabel HEALTH_LABEL = new JLabel();

    /**
     * Instantiation of the health bar
     */
    public HealthBar() {
        setLayout(new GridLayout(2, 1));
        HEALTH_LABEL.setForeground(Color.green);
        HEALTH_LABEL.setHorizontalAlignment(SwingConstants.LEFT);
        add(HEALTH_LABEL);
        JPanel BAR_PANEL = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(getHealthWidth(), 0, (GameController.WIDTH / 3) - getHealthWidth(), 15);
                g.setColor(Color.GREEN);
                g.fillRect(0, 0, getHealthWidth(), 15);
            }
        };
        add(BAR_PANEL);
        setBackground(Color.black);
    }

    /**
     * Get health panel width
     *
     * @return health panel width
     */
    private int getHealthWidth() {
        int currentHealthWidth = (int) ((GameController.WIDTH / 3) * ((float) World.getInstance().getSpacecraft().getHealth() / SpaceCraft.HEALTH));
        return Math.max(0, currentHealthWidth);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        HEALTH_LABEL.setText("Health : " + World.getInstance().getSpacecraft().getHealth());
    }
}
