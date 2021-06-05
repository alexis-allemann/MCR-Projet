package views;

import bullets.Bullet;
import controllers.Controller;
import controllers.MoveDirection;
import fighters.Fighter;

import javax.swing.*;
import java.awt.*;
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
                                controller.move(MoveDirection.TOP);
                                break;

                            case KeyEvent.VK_S:
                            case KeyEvent.VK_DOWN:
                                controller.move(MoveDirection.DOWN);
                                break;

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

    @Override
    public void paintFighter(Fighter fighter) {
        Point point = fighter.getPosition();
        panel.getGraphics().drawImage(fighter.getImage(), point.x, point.y, null);
    }

    @Override
    public void removeFighter(Fighter spacecraft) {
        //récuperer le point
        //redessiner par dessus
        Point point = spacecraft.getPosition();
        panel.getGraphics().drawRect(point.x, point.y, 100, 100);
        panel.getGraphics().fillRect(point.x, point.y, 100, 100);
    }

    @Override
    public void removeBullet(Bullet bullet) {
        Point point = bullet.getPosition();
        panel.getGraphics().drawRect(point.x, point.y, 100, 100);
        panel.getGraphics().fillRect(point.x, point.y, 100, 100);
    }

    @Override
    public void paintBullet(Bullet bullet){
        Point point = bullet.getPosition();
        panel.getGraphics().drawImage(bullet.getImage(), point.x, point.y, null);
    }
}
