package views;

import controllers.Controller;
import controllers.Direction;
import controllers.GamePlay;
import model.World;
import model.components.GameComponentWithHitBox;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

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
        MultiKeyPressListener keyListener = new MultiKeyPressListener();
        frame.addKeyListener(keyListener);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Set<Integer> pressedKeys = keyListener.getPressedKeys();
                if (!pressedKeys.isEmpty()) {
                    for (Iterator<Integer> it = pressedKeys.iterator(); it.hasNext(); ) {
                        switch (it.next()) {
                            case KeyEvent.VK_A:
                            case KeyEvent.VK_LEFT:
                                controller.move(Direction.LEFT);
                                break;

                            case KeyEvent.VK_D:
                            case KeyEvent.VK_RIGHT:
                                controller.move(Direction.RIGHT);
                                break;

                            case KeyEvent.VK_W:
                            case KeyEvent.VK_UP:
                            case KeyEvent.VK_SPACE:
                                controller.shoot();
                                break;

                            case KeyEvent.VK_R:
                            case KeyEvent.VK_N:
                                controller.newGame();
                                break;
                        }
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, GamePlay.FRAME_RATE);
    }

    @Override
    public void paintImage(Image image) {
        panel.getGraphics().drawImage(image, 0, 0, panel);
    }

    @Override
    public Image getBufferedImage() {
        return panel.createImage(WIDTH, HEIGHT);
    }
}
