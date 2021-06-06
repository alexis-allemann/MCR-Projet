package controllers.gameplay;

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

        }
    }
}
