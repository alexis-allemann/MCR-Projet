package controllers;

import bullets.Bullet;
import fighters.Fighter;
import fighters.SpaceCraft;
import views.View;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Space invaders gameplay management
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class GamePlay implements Controller {
    private static GamePlay instance = new GamePlay();
    private Collection<Fighter> monsters = new LinkedList<>();
    private Fighter spacecraft = new SpaceCraft();

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
        view.startView(this);
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
        switch (direction) {
            case LEFT:
                System.out.println("move left");
                break;
            case RIGHT:
                System.out.println("move right");
                break;
        }
    }
}
