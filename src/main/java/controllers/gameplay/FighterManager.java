package controllers.gameplay;

import controllers.GamePlay;
import components.fighters.Fighter;
import components.physics.Location;

import java.util.*;

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
            List<Fighter> monstersCopy = new LinkedList<>(getMonsters());
            for(Fighter monster : monstersCopy){
                if(!monster.alive()) {
                    monster.die();
                }
                else {
                    monster.shoot();
                    monster.move();
                }

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
    public synchronized Collection<Fighter> getMonsters() {
        // Need to return a copy to avoid concurrences errors
        return new ArrayList<>(monsters);
    }

    /**
     * Remove monster from the list
     * @param fighter Fighter to remove
     */
    public void removeMonster(Fighter fighter) {
        monsters.remove(fighter);
    }

    /**
     * Generate a new wave of monster if possible
     * @details check that the highest monster is below the spawn line
     */
     private void checkMonsterGeneration(){
         boolean canGenerate = monsters.isEmpty() || monsters.get(monsters.size() -1).getLocation().y < GamePlay.SPAWN_HEIGHT;
         // 2. if yes generate from level
         if(canGenerate) {
             for(int i = 0; i < GamePlay.getInstance().getLevel().getNbMonsterByWave(); ++i) {
                 // TODO : Generate proper location for the monster
                 Location monsterLocation = new Location(50.f * i, GamePlay.SPAWN_HEIGHT - 20.f);
                 Fighter newMonster = GamePlay.getInstance().getLevel().generateMonster(monsterLocation);
                 monsters.add(newMonster);
             }
         }
     }


}