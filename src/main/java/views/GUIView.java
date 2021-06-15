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
    private final JPanel mainPanel = new JPanel();
    private final JPanel gamePanel = new JPanel();
    private final JPanel infoPanel = new JPanel();
    private final JPanel healthPanel = new JPanel();
    private final JLabel scoreLabel = new JLabel();
    private final JLabel levelLabel = new JLabel();
    private final JLabel healthLabel = new JLabel();
    private final JPanel healthRectangle = new JPanel();

    @Override
    public void startView(Controller controller) {
        setTitle("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - GamePlay.WIDTH / 2, dim.height / 2 - GamePlay.HEIGHT / 2);
        setResizable(false);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        getContentPane().add(mainPanel);

        scoreLabel.setForeground(Color.green);
        levelLabel.setForeground(Color.green);
        healthLabel.setForeground(Color.green);
        healthLabel.setHorizontalAlignment(SwingConstants.CENTER);

        infoPanel.setLocation(new Point(0, 0));
        infoPanel.setPreferredSize(new Dimension(GamePlay.WIDTH, GamePlay.INFO_PANEL_HEIGHT));
        infoPanel.setBackground(Color.BLACK);
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        infoPanel.add(levelLabel, BorderLayout.LINE_START);
        infoPanel.add(scoreLabel, BorderLayout.LINE_END);
        infoPanel.add(healthPanel, BorderLayout.CENTER);
        mainPanel.add(infoPanel);

        healthPanel.setBackground(Color.black);
        healthPanel.setLayout(new FlowLayout());
        healthPanel.add(healthLabel);
        healthPanel.add(healthRectangle);

        healthRectangle.setBackground(Color.green);
        healthRectangle.setPreferredSize(new Dimension(getHealthWidth(), 20));

        gamePanel.setLocation(new Point(0, GamePlay.INFO_PANEL_HEIGHT));
        gamePanel.setPreferredSize(new Dimension(GamePlay.WIDTH, GamePlay.HEIGHT - GamePlay.INFO_PANEL_HEIGHT));
        gamePanel.setBackground(Color.BLACK);
        mainPanel.add(gamePanel);

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
        levelLabel.setText("Level : " + world.getLevel());
        scoreLabel.setText("Score : " + world.getLevel().getScore());
        healthLabel.setText("Health : " + world.getSpacecraft().getHealth());
        healthRectangle.setPreferredSize(new Dimension(getHealthWidth(), 20));
        gamePanel.getGraphics().drawImage(image, 0, 0, gamePanel);
    }

    @Override
    public Image getBufferedImage() {
        Image image = gamePanel.createImage(GamePlay.WIDTH, GamePlay.HEIGHT);
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