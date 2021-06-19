package controllers;

import managers.ComponentManager;
import model.World;
import model.components.fighters.IFighter;
import utils.Utils;
import utils.physics.Direction;
import managers.ViewManager;
import utils.physics.Speed;
import views.View;

/**
 * Space invaders gameplay management
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class GameController implements IController {
    public static final int INFO_PANEL_HEIGHT = Integer.parseInt(Utils.getInstance().getProperty("INFO_PANEL_HEIGHT"));
    public static final int HEIGHT = Integer.parseInt(Utils.getInstance().getProperty("HEIGHT"));
    public static final int WIDTH = Integer.parseInt(Utils.getInstance().getProperty("WIDTH"));
    public static final int FRAME_RATE = Integer.parseInt(Utils.getInstance().getProperty("FRAME_RATE"));
    private static final GameController INSTANCE = new GameController();

    /**
     * Private constructor to implement Singleton pattern
     */
    private GameController() {
    }

    /**
     * Get gameplay instance
     *
     * @return the gameplay instance
     */
    public static GameController getInstance() {
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
        Speed speed = sp.getSpeed();
        int moveOnX = 0;
        switch (direction) {
            case LEFT:
                if (speed.getX() > 0)
                    moveOnX = (int) (-1 * speed.getX());
                else
                    moveOnX = (int) (speed.getX());
                break;
            case RIGHT:
                if (speed.getX() < 0)
                    moveOnX = (int) (-1 * speed.getX());
                else
                    moveOnX = (int) (speed.getX());
                break;
        }
        sp.setSpeed(moveOnX, 0);
        sp.move();
    }
}