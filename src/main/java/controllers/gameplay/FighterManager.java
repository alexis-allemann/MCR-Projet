package controllers.gameplay;

import controllers.GamePlay;
import model.World;
import model.components.fighters.Fighter;
import model.components.physics.Location;
import model.components.weapon.bullets.Bullet;

import java.util.*;

/**
 * Thread that manage fighters actions (movements and shootings)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class FighterManager implements Runnable {
    private static FighterManager instance = new FighterManager();

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
            List<Fighter> monsters = retrieveMonsters();
            List<Fighter> toRemove = new LinkedList<>();
            for (Fighter monster : monsters) {
                if (!monster.alive()) {
                    // Add dead monster to list
                    toRemove.add(monster);
                } else {
                    monster.shoot();
                    monster.move();
                }
            }
            // Remove monster after iteration, else big exception occurs
            for(Fighter monster : toRemove){
                monster.die();
            }

            try {
                Thread.sleep(GamePlay.FRAMERATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Generate a new wave of monster if possible
     *
     * @details check that the highest monster is below the spawn line
     */
    private void checkMonsterGeneration() {
        List<Fighter> monsters = retrieveMonsters();
        boolean canGenerate = monsters.isEmpty() || monsters.get(monsters.size() - 1).getLocation().y < GamePlay.SPAWN_HEIGHT;
        if (canGenerate) {
            float first_one = 15.f;
            for (int i = 0; i < World.getInstance().getLevel().getNbMonsterByWave(); ++i) {
                // TODO : Generate proper location for the monster
                Location monsterLocation = new Location(95.f * i + first_one, GamePlay.SPAWN_HEIGHT);
                Fighter newMonster = World.getInstance().getLevel().generateMonster(monsterLocation);
                World.getInstance().addMonster(newMonster);
            }
        }
    }

    /**
     * Get monsters in the game
     *
     * @return list of fighters in the game
     */
    private List<Fighter> retrieveMonsters() {
        return World.getInstance().getMonsters();
    }
}