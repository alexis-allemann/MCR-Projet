package controllers;

import controllers.managers.ComponentManager;
import model.World;
import model.components.fighters.IFighter;
import utils.physics.Location;
import controllers.managers.ViewManager;
import views.View;

import java.util.Properties;

import java.util.logging.Logger;

/**
 * Space invaders gameplay management
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class GamePlay implements IController {
    public static int INFO_PANEL_HEIGHT;
    public static int HEIGHT;
    public static int WIDTH;
    public static int FRAME_RATE;
    private static final GamePlay instance = new GamePlay();
    private static final Logger LOG = Logger.getLogger(GamePlay.class.getName());

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

        LOG.info("Reading properties");

        if (!properties.containsKey("FRAME_RATE"))
            throw new IllegalArgumentException("Property FRAME_RATE missing in");

        if (!properties.containsKey("HEIGHT"))
            throw new IllegalArgumentException("Property HEIGHT missing");

        if (!properties.containsKey("WIDTH"))
            throw new IllegalArgumentException("Property WIDTH missing");

        if (!properties.containsKey("INFO_PANEL_HEIGHT"))
            throw new IllegalArgumentException("Property SPAWN_HEIGHT missing");

        FRAME_RATE = Integer.parseInt(properties.getProperty("FRAME_RATE"));
        HEIGHT = Integer.parseInt(properties.getProperty("HEIGHT"));
        WIDTH = Integer.parseInt(properties.getProperty("WIDTH"));
        INFO_PANEL_HEIGHT = Integer.parseInt(properties.getProperty("INFO_PANEL_HEIGHT"));

        resetSpaceCraftLocation();
        view.startView(this);

        new Thread(ComponentManager.getInstance()).start();
        new Thread(ViewManager.getInstance(view)).start();
    }

    @Override
    public void shoot() {
        IFighter sp = World.getInstance().getSpacecraft();
        sp.getWeapon().shoot();
    }

    @Override
    public void newGame() {
        LOG.info("New game started");
    }

    @Override
    public void move(Direction direction) {
        Location location = World.getInstance().getSpacecraft().getLocation();
        int moveOnX = 0;
        switch (direction) {
            case LEFT:
                moveOnX = -10;
                break;
            case RIGHT:
                moveOnX = 10;
                break;
        }
        if (isInBounds(new Location(location.x + moveOnX, location.y), World.getInstance().getSpacecraft()))
            World.getInstance().getSpacecraft().getLocation().translate(moveOnX, 0);
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    /**
     * Reset default location of the spacecraft
     */
    private void resetSpaceCraftLocation() {
        IFighter spacecraft = World.getInstance().getSpacecraft();
        spacecraft.setLocation(new Location(
                (GamePlay.WIDTH - spacecraft.getImageWidth()) / 2.f,
                GamePlay.HEIGHT - spacecraft.getImageHeight() - GamePlay.INFO_PANEL_HEIGHT
        ));
    }

    /**
     * Check if a location of a fighter is in view bounds
     *
     * @param location of the fighter
     * @param fighter  to get image width and height
     * @return boolean if it is in bounds
     */
    private boolean isInBounds(Location location, IFighter fighter) {
        // TODO: est-ce que l'on peut considérer ca comme du code dupliqué ?
        return location.x <= WIDTH &&
                location.y <= HEIGHT &&
                location.x + fighter.getImageWidth() >= 0 &&
                location.y + fighter.getImageHeight() >= 0;
    }
}