package controllers.gameplay;

import controllers.GamePlay;
import components.fighters.Fighter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Thread that manage fighters actions (movements and shootings)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class FighterManager implements Runnable {
    private static FighterManager instance = new FighterManager();
    private Collection<Fighter> monsters = new LinkedList<>();

    /**
     * Instantiation of the fighter manager
     */
    private FighterManager() {
    }

    /**
     * Get instance of the fighter manager to implement singleton pattern
     *
     * @return the instance of the fighter manager
     */
    public static FighterManager getInstance() {
        return instance;
    }

    @Override
    public void run() {
        while (GamePlay.getInstance().isRunning()) {
            for (Fighter fighter : monsters) {
                // TODO move and shoot
            }
            try {
                Thread.sleep(GamePlay.FRAMERATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get monsters in the game
     *
     * @return copy of the list of monsters int the game
     */
    public Collection<Fighter> getMonsters() {
        // Need to return a copy to avoid concurrences errors
        return new ArrayList<>(monsters);
    }
}