package controllers.gameplay;

import controllers.GamePlay;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Thread that manage components
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class ComponentManager implements Runnable {
    private static final ComponentManager INSTANCE = new ComponentManager();

    /**
     * Instantiation of the component manager
     */
    private ComponentManager() {
    }

    /**
     * Get instance of the component manager to implement singleton pattern
     *
     * @return the instance of the component manager
     */
    public static ComponentManager getInstance() {
        return INSTANCE;
    }

    @Override
    public void run() {
        FighterManager fighterManager = FighterManager.getInstance();
        BulletManager bulletManager = BulletManager.getInstance();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Check if game is still running
                if (!GamePlay.getInstance().isRunning()) {
                    cancel();
                    timer.cancel();
                }

                fighterManager.manage();
                bulletManager.manage();
            }
        };
        timer.scheduleAtFixedRate(task, 0, GamePlay.FRAME_RATE);
    }
}
