package controllers;

import controllers.managers.ComponentManager;
import model.World;
import model.components.fighters.IFighter;
import utils.Utils;
import utils.physics.Location;
import controllers.managers.ViewManager;
import utils.physics.Vector2D;
import views.View;

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
    private static final GamePlay INSTANCE = new GamePlay();

    /**
     * Private constructor to implement Singleton pattern
     */
    private GamePlay() {
        Utils utils = Utils.getInstance();
        FRAME_RATE = Integer.parseInt(utils.getProperty("FRAME_RATE"));
        HEIGHT = Integer.parseInt(utils.getProperty("HEIGHT"));
        WIDTH = Integer.parseInt(utils.getProperty("WIDTH"));
        INFO_PANEL_HEIGHT = Integer.parseInt(utils.getProperty("INFO_PANEL_HEIGHT"));
    }

    /**
     * Get gameplay instance
     *
     * @return the gameplay instance
     */
    public static GamePlay getInstance() {
        return INSTANCE;
    }

    @Override
    public void start(View view) {
        newGame();
        view.startView(this);
        new Thread(ViewManager.getInstance(view)).start();
        new Thread(ComponentManager.getInstance()).start();
    }

    @Override
    public void shoot() {
        IFighter sp = World.getInstance().getSpacecraft();
        sp.shoot();
    }

    @Override
    public void newGame() {
        World.getInstance().reset();
    }

    @Override
    public void move(Direction direction) {
        IFighter sp = World.getInstance().getSpacecraft();
        Vector2D speed = sp.getSpeed();
        int moveOnX = 0;
        switch (direction) {
            case LEFT:
                moveOnX = (int) (-1 * speed.getX());
                break;
            case RIGHT:
                moveOnX = (int) (speed.getX());
                break;
        }
        sp.setSpeed(moveOnX, 0);
        sp.move();
    }

    /**
     * Check if a location of a fighter is in view bounds
     *
     * @param location of the fighter
     * @param fighter  to get image width and height
     * @return boolean if it is in bounds
     */
    private boolean isInBounds(Location location, IFighter fighter) {
        return location.x + fighter.getImageWidth() <= WIDTH &&
                location.y + fighter.getImageHeight() <= HEIGHT &&
                location.x >= 0 &&
                location.y >= 0;
    }
}