package controllers;

import components.bullets.Bullet;
import components.fighters.Fighter;
import components.fighters.SpaceCraft;
import views.View;

import java.awt.Point;
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
    private Fighter spacecraft;
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private int score = 0;

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

        this.spacecraft = new SpaceCraft(new Point(100, 100));
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
        //TODO: à mettre dans un thread, un joueur doit pouvoir shooter et se déplacer en meme temps
        //faire apparaitre le missile
        //incrementer sa position en y de sorte à le faire partir vers le haut
        //dès qu'il touche qqch , BOOM
        Bullet bullet = spacecraft.getBullet();
        boolean notTouched = true;

        //tant que la bullet est dans le cadre de la frame on incrémente sa position ET qu'elle n'a pas touché qqn
        while (isInBounds(bullet.getLocation()) && notTouched) {

            //TODO : Remplacer + 20 par la moitié de la taille en largeur du vaisseau
            Point point = new Point(bullet.getLocation().x + 20, bullet.getLocation().y - 10);
            bullet.setLocation(point);

            //TODO : maintenir une liste de position de chaque élément afin de détecter si la balle touche qqch

            //view.removeBullet(bullet);
            view.paintBullet(bullet);

        }
        System.out.println("shoot");
    }

    private boolean isInBounds(Point position) {
        return position.x <= WIDTH && position.y <= HEIGHT && position.x >= 0 && position.y >= 0;
    }

    @Override
    public void move(MoveDirection direction) {
        Point position = spacecraft.getLocation();
        switch (direction) {
            case LEFT:
                System.out.println("move left");
                spacecraft.setLocation(new Point(position.x - 10, position.y));
                break;
            case RIGHT:
                System.out.println("move right");
                spacecraft.setLocation(new Point(position.x + 10, position.y));
                break;
        }
        view.removeFighter(spacecraft);
        view.paintFighter(spacecraft);
    }
}
