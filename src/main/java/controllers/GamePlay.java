package controllers;

import components.physics.Location;
import components.weapon.StandardWeapon;
import controllers.gameplay.BulletManager;
import components.fighters.Fighter;
import components.fighters.SpaceCraft;
import controllers.gameplay.FighterManager;
import controllers.gameplay.ViewManager;
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
    private Fighter spacecraft;
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

        LOG.info("Starting game");
        new Thread(BulletManager.getInstance()).start();
        new Thread(FighterManager.getInstance()).start();
        new Thread(ViewManager.getInstance(view)).start();

        LOG.info("Starting view");
        view.startView(this);

        spacecraft = new SpaceCraft(new Location(0, 0));
        spacecraft.setWeapon(new StandardWeapon());

        ViewManager.getInstance().resetSpaceCraftLocation(spacecraft);
        view.paintComponent(spacecraft);
    }

    @Override
    public void shoot() {
        spacecraft.getWeapon().shoot();
    }

    @Override
    public void newGame() {
        LOG.info("New game started");
    }

    @Override
    public void move(Direction direction) {
        ViewManager.getInstance().move(direction, spacecraft);
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    /**
     * @return The spacecraft of the game
     */
    public Fighter getSpacecraft(){
        return spacecraft;
    }

    /**
     * @return the current level
     */
    public Level getLevel(){ return level; }

}