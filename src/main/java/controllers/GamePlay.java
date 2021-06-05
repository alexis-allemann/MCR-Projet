package controllers;

import bullets.Bullet;
import fighters.Fighter;
import fighters.SpaceCraft;
import views.View;

import javax.imageio.ImageIO;
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
    //TODO il faudra mettre à jours la liste de monstres à chaque vagues (afin de connaitre la positon de chacun d'entre eux)
    private Collection<Fighter> monsters = new LinkedList<>();
    private Fighter spacecraft = new SpaceCraft();
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

        spacecraft.setPosition(new Point( 50,50));
        this.view = view;
        view.startView(this);
        view.paintFighter(spacecraft);
    }

    @Override
    public void newGame() {
        System.out.println("new game");
    }


    //TODO: à mettre dans un thread, un joueur doit pouvoir shooter et se déplacer en meme temps
    @Override
    public void shoot() {
        //faire apparaitre le missile
        //incrementer sa position en y de sorte à le faire partir vers le haut
        //dès qu'il touche qqch , BOOM
        Bullet bullet = spacecraft.getBullet();
        boolean notTouched = true;

        //tant que la bullet est dans le cadre de la frame on incrémente sa position ET qu'elle n'a pas touché qqn
        while(isInBounds(bullet.getPosition()) && notTouched) {

            //TODO : Remplacer + 20 par la moitié de la taille en largeur du vaisseau
            Point point = new Point(bullet.getPosition().x + 20 , bullet.getPosition().y - 10);
            bullet.setPosition(point);

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
            case DOWN:
                System.out.println("move down");
                spacecraft.setPosition(new Point(position.x, position.y + 10));
                break;
            case TOP:
                System.out.println("move top");
                spacecraft.setPosition(new Point(position.x, position.y - 10));
        }
        view.removeFighter(spacecraft);
        view.paintFighter(spacecraft);
    }


}
