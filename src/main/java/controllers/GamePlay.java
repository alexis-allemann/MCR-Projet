package controllers;

import fighters.Fighter;
import fighters.SpaceCraft;
import views.View;

import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;
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
    private Collection<Fighter> monsters = new LinkedList<>();
    private Fighter spacecraft = new SpaceCraft();

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
    public void start(View view) {
        if (view == null)
            throw new IllegalArgumentException("View can not be null");

        LOG.log(Level.INFO, "Game started");

        spacecraft.setPosition(new Point(50, 50));
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
        System.out.println("shoot");
    }

    @Override
    public void move(MoveDirection direction) {
        Point position = spacecraft.getPosition();
        switch (direction) {
            case LEFT:
                System.out.println("move left");
                spacecraft.setPosition(new Point(position.x - 10, position.y));
                break;
            case RIGHT:
                System.out.println("move right");
                spacecraft.setPosition(new Point(position.x + 10, position.y));
                break;
        }
        view.paintFighter(spacecraft);
    }


}
