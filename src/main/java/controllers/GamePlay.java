package controllers;

import components.bullets.Bullet;
import components.physics.Location;
import controllers.gameplay.BulletManager;
import components.fighters.GameComponent;
import components.fighters.SpaceCraft;
import controllers.gameplay.FighterManager;
import controllers.gameplay.ViewManager;
import views.View;

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
    public static int HEIGHT;
    public static int WIDTH;
    public static int FRAMERATE;
    private static final Logger LOG = Logger.getLogger(GamePlay.class.getName());
    private static GamePlay instance = new GamePlay();
    private View view;
    private Collection<GameComponent> fighters = new LinkedList<>();
    private Collection<Bullet> bullets = new LinkedList<>();
    private GameComponent spacecraft;
    private Level level;

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

        LOG.log(Level.INFO, "Reading properties");

        if (!properties.containsKey("FRAMERATE"))
            throw new IllegalArgumentException("Property FRAMERATE missing in");

        if (!properties.containsKey("HEIGHT"))
            throw new IllegalArgumentException("Property HEIGHT missing");

        if (!properties.containsKey("WIDTH"))
            throw new IllegalArgumentException("Property WIDTH missing");

        FRAMERATE = Integer.parseInt(properties.getProperty("FRAMERATE"));
        HEIGHT = Integer.parseInt(properties.getProperty("HEIGHT"));
        WIDTH = Integer.parseInt(properties.getProperty("WIDTH"));

        LOG.log(Level.INFO, "Starting game");
        new Thread(BulletManager.getInstance(this)).start();
        new Thread(FighterManager.getInstance(this)).start();
        new Thread(ViewManager.getInstance(this)).start();

        LOG.log(Level.INFO, "Starting view");
        this.view = view;
        view.startView(this);

        spacecraft = new SpaceCraft(new Location(0, 0));
        resetSpaceCraftLocation();
        view.paintComponent(spacecraft);
    }

    @Override
    public void newGame() {
        LOG.log(Level.INFO, "New game started");
    }

    @Override
    public void shoot() {
        // appel le spacecraft pour shoot
    }

    @Override
    public void move(MoveDirection direction) {
        Location position = spacecraft.getLocation();
        int moveOnX = 0;
        switch (direction) {
            case LEFT:
                moveOnX = -10;
                break;
            case RIGHT:
                moveOnX = 10;
                break;
        }
        if (isInBounds(new Location(position.x + moveOnX, position.y), spacecraft))
            spacecraft.setLocation(new Location(position.x + moveOnX, position.y));
        view.removeComponent(spacecraft);
        view.paintComponent(spacecraft);
    }

    @Override
    public boolean isRunning() {
        return true;
    }


    public Collection<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Collection<Bullet> bullets) {
        this.bullets = bullets;
    }

    public Collection<GameComponent> getFighters() {
        return fighters;
    }

    /**
     * Check if a location of a fighter is in view bounds
     *
     * @param location of the fighter
     * @param fighter  to get image width and height
     * @return boolean if it is in bounds
     */
    private boolean isInBounds(Location location, GameComponent fighter) {
        return location.x + fighter.getImageWidth() <= WIDTH &&
                location.y + fighter.getImageHeight() <= HEIGHT &&
                location.x >= 0 &&
                location.y >= 0;
    }

    /**
     * Reset default location of the spacecraft
     */
    private void resetSpaceCraftLocation() {
        spacecraft.setLocation(new Location((WIDTH - spacecraft.getImageWidth()) / 2, HEIGHT - spacecraft.getImageHeight()));
    }
}