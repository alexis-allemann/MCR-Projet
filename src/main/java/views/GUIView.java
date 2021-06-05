package views;

import controllers.Controller;
import controllers.MoveDirection;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

    @Override
    public void startView(Controller controller) {
        frame = new JFrame();
        frame.setTitle("Space Invaders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - this.WIDTH / 2, dim.height / 2 - HEIGHT / 2);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setVisible(true);

        // Listen keys pressed
        frame.addKeyListener(
                new KeyAdapter() {

                    /**
                     * A key is pressed
                     *
                     * @param keyEvent the event data
                     */
                    @Override
                    public void keyPressed(KeyEvent keyEvent) {

                        switch (keyEvent.getKeyCode()) {
                            case KeyEvent.VK_A:
                            case KeyEvent.VK_LEFT:
                                controller.move(MoveDirection.LEFT);
                                break;

                            case KeyEvent.VK_D:
                            case KeyEvent.VK_RIGHT:
                                controller.move(MoveDirection.RIGHT);
                                break;

                            case KeyEvent.VK_W:
                            case KeyEvent.VK_UP:
                            case KeyEvent.VK_SPACE:
                                controller.shoot();
                                break;

                            case KeyEvent.VK_R:
                            case KeyEvent.VK_N:
                                controller.newGame();
                        }
                    }
                });
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
        // TODO : Display in logs panel the new message
    }
}
