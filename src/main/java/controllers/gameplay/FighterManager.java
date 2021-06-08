package controllers.gameplay;

import controllers.GamePlay;
import components.fighters.Fighter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Thread that manage fighters actions (movements and shootings)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class FighterManager implements Runnable {
    private static FighterManager instance = new FighterManager();
    private List<Fighter> monsters = new LinkedList<>();

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
            // 1. check if we can generate monsters (every 5s i.e.)
            // 1.1 get Y coordinate of highest monsters
            checkMonsterGeneration();
            for (Fighter fighter : monsters) {
                // 3. make all monsters shoots (existing and newly generated)
                // 4. move all monsters to down
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

    /**
     * Generate a new wave of monster if possible
     */
     private void checkMonsterGeneration(){
         boolean canGenerate = !monsters.isEmpty() && monsters.get(monsters.size() -1).getLocation().y < GamePlay.SPAWN_HEIGHT;
         // 2. if yes generate from level
         if(canGenerate) {
             for(int i = 0; i < GamePlay.getInstance().getLevel().getNbMonsterByWave(); ++i) {
                 monsters.push_back(GamePlay.getInstance().getLevel().generateMonster());
             }
         }
     }
}