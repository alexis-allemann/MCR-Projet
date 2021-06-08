package controllers.gameplay;

import components.GameComponent;
import components.bullets.Bullet;
import controllers.GamePlay;

/**
 * Thread that manage the view
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ViewManager implements Runnable {

    private static ViewManager instance;
    private GamePlay gamePlay;

    private ViewManager(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    public static ViewManager getInstance(GamePlay gamePlay) {
        if (instance == null)
            instance = new ViewManager(gamePlay);
        return instance;
    }

    @Override
    public void run() {
        while(gamePlay.isRunning()){
            try {
                Thread.sleep(gamePlay.FRAMERATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
