package controllers;

import components.bullets.Bullet;
import components.physics.Location;
import controllers.gameplay.BulletManager;
import components.fighters.Fighter;
import components.fighters.SpaceCraft;
import controllers.gameplay.FighterManager;
import controllers.gameplay.ViewManager;
import views.View;

import java.awt.Point;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Space invaders gameplay management
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class GamePlay implements Controller {
    static final Logger LOG = Logger.getLogger(GamePlay.class.getName());
    private static GamePlay instance = new GamePlay();
    private View view;
    private Collection<Fighter> fighters = new LinkedList<>();
    private Collection<Bullet> bullets = new LinkedList<>();
    private Fighter spacecraft;
    public static int HEIGHT;
    public static int WIDTH;
    public static int FRAMERATE;
    private int score = 0;
    private boolean isRunning;

    /**
     * Private constructor to implement Singleton pattern
     */
    private GamePlay() {
    }

    /**
     * Get gameplay instance
     *
     * @return the gameplay instance
     */
    public static GamePlay getInstance() {
        return instance;
    }

    @Override
    public void start(View view, Properties properties) {
        if (view == null)
            throw new IllegalArgumentException("View can not be null");

        if (properties == null)
            throw new IllegalArgumentException("Properites can not be null");

        if (!properties.containsKey("FRAMERATE"))
            throw new RuntimeException("Property FRAMERATE missing");

        if (!properties.containsKey("HEIGHT"))
            throw new RuntimeException("Property HEIGHT missing");

        if (!properties.containsKey("WIDTH"))
            throw new RuntimeException("Property WIDTH missing");

        FRAMERATE = Integer.parseInt(properties.getProperty("FRAMERATE"));
        HEIGHT = Integer.parseInt(properties.getProperty("HEIGHT"));
        WIDTH = Integer.parseInt(properties.getProperty("WIDTH"));

        LOG.log(Level.INFO, "Game started");

        new Thread(BulletManager.getInstance(this)).start();
        new Thread(FighterManager.getInstance(this)).start();
        new Thread(ViewManager.getInstance(this)).start();

        this.spacecraft = new SpaceCraft(new Location(100, 100));
        this.view = view;
        view.startView(this);
        view.paintFighter(spacecraft);
    }

    @Override
    public void newGame() {
        System.out.println("new game");
    }

    @Override
    public void shoot() {
        // appel le spacecraft pour shoot
    }

    @Override
    public void move(MoveDirection direction) {
        Location position = spacecraft.getLocation();
        switch (direction) {
            case LEFT:
                System.out.println("move left");
                spacecraft.setLocation(new Location(position.x - 10, position.y));
                break;
            case RIGHT:
                System.out.println("move right");
                spacecraft.setLocation(new Location(position.x + 10, position.y));
                break;
        }
        view.removeFighter(spacecraft);
        view.paintFighter(spacecraft);
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    private boolean isInBounds(Point position) {
        Properties properties = new Properties();
        final int WIDTH = Integer.parseInt(properties.getProperty("WIDTH"));
        final int HEIGHT = Integer.parseInt(properties.getProperty("HEIGHT"));
        return position.x <= WIDTH && position.y <= HEIGHT && position.x >= 0 && position.y >= 0;
    }

    public Collection<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Collection<Bullet> bullets) {
        this.bullets = bullets;
    }

    public Collection<Fighter> getFighters() {
        return fighters;
    }
}
