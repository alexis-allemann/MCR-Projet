package views;

import controllers.GamePlay;
import model.World;
import model.components.fighters.SpaceCraft;

import javax.swing.*;
import java.awt.*;

public class HealthBar extends JPanel {
    private final JLabel HEALTH_LABEL = new JLabel();

    public HealthBar() {
        HEALTH_LABEL.setForeground(Color.green);
        HEALTH_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        add(HEALTH_LABEL);
        setBackground(Color.black);
        setLayout(new FlowLayout());
    }

    /**
     * Get health panel width
     *
     * @return health panel width
     */
    private int getHealthWidth() {
        return (int) ((GamePlay.WIDTH / 3) / (SpaceCraft.MAX_HEALTH / (float) World.getInstance().getSpacecraft().getHealth()));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        HEALTH_LABEL.setText("Health : " + World.getInstance().getSpacecraft().getHealth());
    }
}
