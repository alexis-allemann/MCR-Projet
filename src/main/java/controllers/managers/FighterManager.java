package controllers.managers;

import controllers.GamePlay;
import model.components.fighters.IFighter;
import model.levels.Level;
import model.World;
import utils.physics.Location;

import java.util.List;
import java.util.LinkedList;

/**
 * Thread that manage fighters actions (movements and shootings)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class FighterManager {
    private static final FighterManager INSTANCE = new FighterManager();

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
        return INSTANCE;
    }

    /**
     * Manage fighters actions
     */
    public void manage() {
        World world = World.getInstance();

        // Check if level has changed
        world.getLevel().checkLevelChanged();

        // Check if new monsters can be generated
        checkMonsterGeneration();

        // Lock monsters list instance to prevent concurrences errors
        synchronized (world.getMonsters()) {
            List<IFighter> monsters = world.getMonsters();
            List<IFighter> toRemove = new LinkedList<>();
            for (IFighter monster : monsters) {
                if (!monster.isAlive()) {
                    toRemove.add(monster);
                    world.getLevel().addMonsterKilled();
                } else {
                    monster.shoot();
                    monster.setNextSpeed();
                    monster.move();
                }
            }

            // Remove monster after iteration to handle concurrence in synchronised list
            for (IFighter monster : toRemove)
                monster.die();

            // Check if the spacecraft is still alive
            if (!world.getSpacecraft().isAlive())
                world.setRunning(false);
        }
    }


    /**
     * Generate a new wave of monster if possible
     *
     * @details check that the highest monster is below the spawn line
     */
    private void checkMonsterGeneration() {
        World world = World.getInstance();
        synchronized (world.getMonsters()) {
            List<IFighter> monsters = world.getMonsters();

            // Check if a new generation should happen
            boolean canGenerate;
            if (monsters.isEmpty()) {
                canGenerate = true;
            } else {
                IFighter last = monsters.get(monsters.size() - 1);
                canGenerate = last.getLocation().y > last.getImageHeight();
            }

            // Generate new monsters
            if (canGenerate) {
                Level level = world.getLevel();
                int margin = ((GamePlay.WIDTH) / (level.getNbMonsterByWave()));
                for (int i = 1; i <= level.getNbMonsterByWave(); ++i) {
                    IFighter newMonster = level.generateMonster(new Location(0, 0));
                    int xAxisValue = (margin * i) - (margin / 2) - (newMonster.getImageWidth() / 2);
                    newMonster.setLocation(new Location(xAxisValue, 0));
                    world.addMonster(newMonster);
                }
            }
        }
    }
}