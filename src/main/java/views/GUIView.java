package views;

import components.GameComponent;
import components.physics.Location;
import controllers.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;

/**
 * GUI view to display gameplay
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class GUIView implements View {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    @Override
    public void startView(Controller controller) {
        frame = new JFrame();
        frame.setTitle("Space Invaders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - this.WIDTH / 2, dim.height / 2 - HEIGHT / 2);
        frame.setResizable(false);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setBackground(Color.BLACK);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();
        frame.addKeyListener(new MultiKeyPressListener(controller));
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
        // TODO : Display in logs panel the new message
    }

    @Override
    public void paintComponent(GameComponent component) {
        Location point = component.getLocation();
        panel.getGraphics().drawImage(component.getImage(), (int) point.x, (int) point.y, null);
    }

    @Override
    public void removeComponent(GameComponent component) {
        Location point = component.getLocation();
        panel.getGraphics().drawRect((int) point.x, (int) point.y, component.getImageWidth(), component.getImageHeight());
        panel.getGraphics().fillRect((int) point.x, (int) point.y, component.getImageWidth(), component.getImageHeight());
    }
}
