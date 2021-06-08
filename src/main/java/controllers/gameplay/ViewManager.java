package controllers.gameplay;

import components.GameComponent;
import components.fighters.Fighter;
import components.physics.Location;
import controllers.GamePlay;
import controllers.Direction;
import views.View;

/**
 * Thread that manage the view
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ViewManager implements Runnable {
    private static ViewManager instance;
    private View view;

    /**
     * Instantiation of the view manager
     *
     * @param view to manage
     */
    private ViewManager(View view) {
        this.view = view;
    }

    /**
     * Get instance of the view manager to implement singleton pattern
     *
     * @param view to manage
     * @return the instance of the view manager
     */
    public static ViewManager getInstance(View view) {
        if (instance == null)
            instance = new ViewManager(view);
        return instance;
    }

    /**
     * Get instance of the view manager to implement singleton pattern
     *
     * @return the instance of the view manager
     */
    public static ViewManager getInstance() {
        return instance;
    }

    @Override
    public void run() {
        while (GamePlay.getInstance().isRunning()) {
            try {
                Thread.sleep(GamePlay.FRAMERATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Move spacecraft according to given direction
     *
     * @param direction  to move spacecraft
     * @param spacecraft to move
     */
    public void move(Direction direction, Fighter spacecraft) {
        Location location = spacecraft.getLocation();
        int moveOnX = 0;
        switch (direction) {
            case LEFT:
                moveOnX = -10;
                break;
            case RIGHT:
                moveOnX = 10;
                break;
        }
        if (isInBounds(new Location(location.x + moveOnX, location.y), spacecraft))
            spacecraft.setLocation(new Location(location.x + moveOnX, location.y));
        view.removeComponent(spacecraft);
        view.paintComponent(spacecraft);
    }

    /**
     * Reset default location of the spacecraft
     *
     * @param spacecraft to reset location
     */
    public void resetSpaceCraftLocation(Fighter spacecraft) {
        spacecraft.setLocation(new Location((GamePlay.WIDTH - spacecraft.getImageWidth()) / 2, GamePlay.HEIGHT - spacecraft.getImageHeight()));
    }

    /**
     * Paint component on view
     *
     * @param component to paint
     */
    public void paintComponent(GameComponent component) {
        view.paintComponent(component);
    }

    /**
     * Remove component from view
     *
     * @param component to remove
     */
    public void removeComponent(GameComponent component) {
        view.removeComponent(component);
    }

    /**
     * Check if a location of a fighter is in view bounds
     *
     * @param location of the fighter
     * @param fighter  to get image width and height
     * @return boolean if it is in bounds
     */
    private boolean isInBounds(Location location, Fighter fighter) {
        return location.x + fighter.getImageWidth() <= GamePlay.WIDTH &&
                location.y + fighter.getImageHeight() <= GamePlay.HEIGHT &&
                location.x >= 0 &&
                location.y >= 0;
    }
}
