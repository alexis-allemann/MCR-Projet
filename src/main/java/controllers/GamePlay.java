package controllers;

import model.World;
import model.components.physics.Location;
import model.components.weapon.StandardWeapon;
import controllers.gameplay.BulletManager;
import model.components.fighters.Fighter;
import model.components.fighters.SpaceCraft;
import controllers.gameplay.FighterManager;
import controllers.gameplay.ViewManager;
import levels.Beginner;
import levels.Level;
import views.View;

import java.util.Properties;

import java.util.logging.Logger;

/**
 * Space invaders gameplay management
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class GamePlay implements Controller {
    public static final float SPAWN_HEIGHT = 100;
    public static int HEIGHT;
    public static int WIDTH;
    public static int FRAMERATE;
    private static GamePlay instance = new GamePlay();
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

        if (!properties.containsKey("FRAMERATE"))
            throw new IllegalArgumentException("Property FRAMERATE missing in");

        if (!properties.containsKey("HEIGHT"))
            throw new IllegalArgumentException("Property HEIGHT missing");

        if (!properties.containsKey("WIDTH"))
            throw new IllegalArgumentException("Property WIDTH missing");

        FRAMERATE = Integer.parseInt(properties.getProperty("FRAMERATE"));
        HEIGHT = Integer.parseInt(properties.getProperty("HEIGHT"));
        WIDTH = Integer.parseInt(properties.getProperty("WIDTH"));

        resetSpaceCraftLocation();
        view.startView(this);

        new Thread(BulletManager.getInstance()).start();
        new Thread(FighterManager.getInstance()).start();
        new Thread(ViewManager.getInstance(view)).start();
    }

    @Override
    public void shoot() {
        Fighter sp = World.getInstance().getSpacecraft();
        sp.getWeapon().shoot(sp);
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
        retrieveSpacecraft().setLocation(new Location(
                (GamePlay.WIDTH - retrieveSpacecraft().getImageWidth()) / 2.f,
                GamePlay.HEIGHT - retrieveSpacecraft().getImageHeight()
        ));
    }

    /**
     * Check if a location of a fighter is in view bounds
     *
     * @param location of the fighter
     * @param fighter  to get image width and height
     * @return boolean if it is in bounds
     */
    private boolean isInBounds(Location location, Fighter fighter) {
        return location.x + fighter.getImageWidth() <= WIDTH &&
                location.y + fighter.getImageHeight() <= HEIGHT &&
                location.x >= 0 &&
                location.y >= 0;
    }

    private Fighter retrieveSpacecraft(){
        return World.getInstance().getSpacecraft();
    }
}