package views;

import controllers.Controller;
import controllers.Direction;
import controllers.GamePlay;
import model.World;
import model.components.fighters.SpaceCraft;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.Color;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
public class GUIView extends JFrame implements View {
    private final JPanel MAIN_PANEL = new JPanel();
    private final JPanel GAME_PANEL = new JPanel();
    private final JPanel INFO_PANEL = new JPanel();
    private final JPanel HEALTH_PANEL = new JPanel();
    private final JLabel SCORE_LABEL = new JLabel();
    private final JLabel LEVEL_LABEL = new JLabel();
    private final JLabel HEALTH_LABEL = new JLabel();
    private final JPanel HEALTH_RECTANGLE = new JPanel();

    @Override
    public void startView(Controller controller) {
        setTitle("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - GamePlay.WIDTH / 2, dim.height / 2 - GamePlay.HEIGHT / 2);
        setResizable(false);

        MAIN_PANEL.setLayout(new BoxLayout(MAIN_PANEL, BoxLayout.Y_AXIS));
        getContentPane().add(MAIN_PANEL);

        SCORE_LABEL.setForeground(Color.green);
        LEVEL_LABEL.setForeground(Color.green);
        HEALTH_LABEL.setForeground(Color.green);
        HEALTH_LABEL.setHorizontalAlignment(SwingConstants.CENTER);

        INFO_PANEL.setLocation(new Point(0, 0));
        INFO_PANEL.setPreferredSize(new Dimension(GamePlay.WIDTH, GamePlay.INFO_PANEL_HEIGHT));
        INFO_PANEL.setBackground(Color.BLACK);
        INFO_PANEL.setLayout(new BorderLayout());
        INFO_PANEL.setBorder(new EmptyBorder(10, 10, 10, 10));
        INFO_PANEL.add(LEVEL_LABEL, BorderLayout.LINE_START);
        INFO_PANEL.add(SCORE_LABEL, BorderLayout.LINE_END);
        INFO_PANEL.add(HEALTH_PANEL, BorderLayout.CENTER);
        MAIN_PANEL.add(INFO_PANEL);

        HEALTH_PANEL.setBackground(Color.black);
        HEALTH_PANEL.setLayout(new FlowLayout());
        HEALTH_PANEL.add(HEALTH_LABEL);
        HEALTH_PANEL.add(HEALTH_RECTANGLE);

        HEALTH_RECTANGLE.setBackground(Color.green);
        HEALTH_RECTANGLE.setPreferredSize(new Dimension(getHealthWidth(), 20));

        GAME_PANEL.setLocation(new Point(0, GamePlay.INFO_PANEL_HEIGHT));
        GAME_PANEL.setPreferredSize(new Dimension(GamePlay.WIDTH, GamePlay.HEIGHT - GamePlay.INFO_PANEL_HEIGHT));
        GAME_PANEL.setBackground(Color.BLACK);
        MAIN_PANEL.add(GAME_PANEL);

        setVisible(true);
        pack();

        MultiKeyPressListener keyListener = new MultiKeyPressListener();
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

                                case KeyEvent.VK_R:
                                    controller.newGame();
                                    break;
                            }
                        }
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, GamePlay.FRAME_RATE);
    }

    @Override
    public void paintImage(Image image) {
        World world = World.getInstance();
        LEVEL_LABEL.setText("Level : " + world.getLevel());
        SCORE_LABEL.setText("Score : " + world.getLevel().getScore());
        HEALTH_LABEL.setText("Health : " + world.getSpacecraft().getHealth());
        HEALTH_RECTANGLE.setPreferredSize(new Dimension(getHealthWidth(), 20));
        GAME_PANEL.getGraphics().drawImage(image, 0, 0, GAME_PANEL);
    }

    @Override
    public Image getBufferedImage() {
        Image image = GAME_PANEL.createImage(GamePlay.WIDTH, GamePlay.HEIGHT);
        image.getGraphics().fillRect(0, 0, GamePlay.WIDTH, GamePlay.HEIGHT);
        image.getGraphics().setColor(Color.BLACK);
        return image;
    }

    /**
     * Get health panel width
     *
     * @return health panel width
     */
    private int getHealthWidth() {
        return (GamePlay.WIDTH / 3) / (SpaceCraft.MAX_HEALTH / World.getInstance().getSpacecraft().getHealth());
    }
}