package views;

import controllers.GamePlay;
import model.World;
import model.components.fighters.SpaceCraft;

import javax.swing.*;
import java.awt.*;

public class HealthBar extends JPanel {
    private final JLabel HEALTH_LABEL = new JLabel();
    private JPanel BAR_PANEL;

    public HealthBar() {
        setLayout(new GridLayout(2,1));
        HEALTH_LABEL.setForeground(Color.green);
        HEALTH_LABEL.setHorizontalAlignment(SwingConstants.LEFT);
        add(HEALTH_LABEL);
        BAR_PANEL = new JPanel(){
           @Override
           public void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.setColor(Color.RED);
               g.fillRect(getHealthWidth(), 0, (GamePlay.WIDTH / 3) - getHealthWidth(), 15);
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
        int currentHealthWidth = (int) ((GamePlay.WIDTH / 3) * ( (float) World.getInstance().getSpacecraft().getHealth() /SpaceCraft.MAX_HEALTH ));
        return Math.max(0, currentHealthWidth);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        HEALTH_LABEL.setText("Health : " + World.getInstance().getSpacecraft().getHealth());
    }
}
