package controllers.managers;

import controllers.GamePlay;
import model.World;

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
        final FighterManager fighterManager = FighterManager.getInstance();
        final ProjectileManager projectileManager = ProjectileManager.getInstance();
        final Timer timer = new Timer();
        final World world = World.getInstance();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Check if game is still running
                if (world.isRunning()) {
                    fighterManager.manage();
                    projectileManager.manage();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, GamePlay.FRAME_RATE);
    }
}
