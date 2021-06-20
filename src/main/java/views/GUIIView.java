package views;

import controllers.IController;
import utils.physics.Direction;
import controllers.GameController;
import model.World;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Point;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

/**
 * GUI view to display gameplay
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class GUIIView extends JFrame implements IView {
    private final JPanel MAIN_PANEL = new JPanel();
    private final GamePanel GAME_PANEL = new GamePanel();
    private final JPanel INFO_PANEL = new JPanel();
    private final JLabel SCORE_LABEL = new JLabel();
    private final JLabel LEVEL_LABEL = new JLabel();
    private final JPanel HEALTH_BAR = new HealthBar();
    private final JLabel GAME_OVER = new JLabel();

    @Override
    public void startView(final IController controller) {
        setTitle("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - GameController.WIDTH / 2, dim.height / 2 - GameController.HEIGHT / 2);
        setResizable(false);

        MAIN_PANEL.setLayout(new BoxLayout(MAIN_PANEL, BoxLayout.Y_AXIS));
        getContentPane().add(MAIN_PANEL);

        SCORE_LABEL.setForeground(Color.green);
        SCORE_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        LEVEL_LABEL.setForeground(Color.green);

        INFO_PANEL.setLocation(new Point(0, 0));
        INFO_PANEL.setPreferredSize(new Dimension(GameController.WIDTH, GameController.INFO_PANEL_HEIGHT));
        INFO_PANEL.setBackground(Color.BLACK);
        INFO_PANEL.setLayout(new GridLayout(1, 3));
        INFO_PANEL.setBorder(new EmptyBorder(10, 10, 10, 10));
        INFO_PANEL.add(LEVEL_LABEL);
        INFO_PANEL.add(HEALTH_BAR);
        INFO_PANEL.add(SCORE_LABEL);
        MAIN_PANEL.add(INFO_PANEL);

        GAME_PANEL.setLocation(new Point(0, GameController.INFO_PANEL_HEIGHT));
        GAME_PANEL.setPreferredSize(new Dimension(GameController.WIDTH, GameController.HEIGHT - GameController.INFO_PANEL_HEIGHT));
        GAME_PANEL.setBackground(Color.BLACK);
        MAIN_PANEL.add(GAME_PANEL);

        GAME_OVER.setText("Game over, press R or N to restart");
        GAME_OVER.setForeground(Color.RED);
        GAME_OVER.setFont(new Font(GAME_OVER.getFont().getName(), Font.PLAIN, 30));
        GAME_OVER.setHorizontalAlignment(SwingConstants.CENTER);
        GAME_OVER.setVerticalAlignment(SwingConstants.CENTER);
        GAME_OVER.setVisible(false);
        GAME_PANEL.add(GAME_OVER);
        GAME_PANEL.setLayout(new GridLayout());

        setVisible(true);
        pack();

        final MultiKeyPressListener keyListener = new MultiKeyPressListener();
        addKeyListener(keyListener);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                synchronized (keyListener.getPressedKeys()) {
                    Collection<Integer> pressedKeys = keyListener.getPressedKeys();
                    if (!pressedKeys.isEmpty()) {
                        for (Integer pressedKey : pressedKeys) {
                            switch (pressedKey) {
                                case KeyEvent.VK_LEFT:
                                    controller.move(Direction.LEFT);
                                    break;

                                case KeyEvent.VK_RIGHT:
                                    controller.move(Direction.RIGHT);
                                    break;

                                case KeyEvent.VK_UP:
                                case KeyEvent.VK_SPACE:
                                    controller.shoot();
                                    break;

                                case KeyEvent.VK_N:
                                case KeyEvent.VK_R:
                                    GAME_OVER.setVisible(false);
                                    controller.newGame();
                                    break;
                            }
                        }
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, GameController.FRAME_RATE);
    }

    @Override
    public void paintImage(Image image) {
        World world = World.getInstance();
        LEVEL_LABEL.setText("Difficulty : " + world.getLevel().toString());
        SCORE_LABEL.setText("Score : " + world.getLevel().getScore());
        GAME_PANEL.setGameImage(image);
        repaint();
    }

    @Override
    public Image getBufferedImage() {
        Image image = GAME_PANEL.createImage(GameController.WIDTH, GameController.HEIGHT);
        image.getGraphics().fillRect(0, 0, GameController.WIDTH, GameController.HEIGHT);
        image.getGraphics().setColor(Color.BLACK);
        return image;
    }

    @Override
    public void displayGameOverMessage() {
        GAME_OVER.setVisible(true);
    }
}