package views;

import controllers.Controller;
import controllers.Direction;
import controllers.GamePlay;
import model.World;
import model.components.fighters.SpaceCraft;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.*;
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
    private final GamePanel GAME_PANEL = new GamePanel();
    private final JPanel INFO_PANEL = new JPanel();
    private final JLabel SCORE_LABEL = new JLabel();
    private final JLabel LEVEL_LABEL = new JLabel();
    private final JPanel HEALTH_BAR = new HealthBar();

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
        SCORE_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
        LEVEL_LABEL.setForeground(Color.green);

        INFO_PANEL.setLocation(new Point(0, 0));
        INFO_PANEL.setPreferredSize(new Dimension(GamePlay.WIDTH, GamePlay.INFO_PANEL_HEIGHT));
        INFO_PANEL.setBackground(Color.BLACK);
        INFO_PANEL.setLayout(new GridLayout(1,3));
        INFO_PANEL.setBorder(new EmptyBorder(10, 10, 10, 10));
        INFO_PANEL.add(LEVEL_LABEL);
        INFO_PANEL.add(HEALTH_BAR);
        INFO_PANEL.add(SCORE_LABEL);
        MAIN_PANEL.add(INFO_PANEL);

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
        LEVEL_LABEL.setText("Difficulty : " + World.getInstance().getLevel().toString());
        SCORE_LABEL.setText("Score : " + World.getInstance().getLevel().getScore());
        GAME_PANEL.setGameImage(image);
        this.repaint();
    }

    @Override
    public Image getBufferedImage() {
        Image image = GAME_PANEL.createImage(GamePlay.WIDTH, GamePlay.HEIGHT);
        image.getGraphics().fillRect(0, 0, GamePlay.WIDTH, GamePlay.HEIGHT);
        image.getGraphics().setColor(Color.BLACK);
        return image;
    }
}