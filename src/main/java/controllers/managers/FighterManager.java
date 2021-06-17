package controllers.managers;

import controllers.GamePlay;
import model.components.fighters.IFighter;
import model.levels.Level;
import model.World;
import model.components.fighters.Fighter;
import utils.physics.Location;
import utils.physics.Vector2D;

import java.util.List;
import java.util.LinkedList;

/**
 * Thread that manage fighters actions (movements and shootings)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class FighterManager {
    // TODO: est-ce que l'on mettrait pas les initialisation de valeur dans le constructeur plutot? (a débattre)
    private static final FighterManager INSTANCE = new FighterManager();
    private static final int SECONDS_BEFORE_DOWN_MOVE = 2;
    private static final int NB_MOVES_BEFORE_INVERT = 80;
    private long lastMonstersDownMove = System.currentTimeMillis();
    private int nbMoveInSameDirection = 0;

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

            // Check if monsters should move down or invert speed
            boolean downMove = System.currentTimeMillis() - lastMonstersDownMove > SECONDS_BEFORE_DOWN_MOVE * 1000;
            boolean invertSpeed = nbMoveInSameDirection > NB_MOVES_BEFORE_INVERT;

            List<IFighter> monsters = world.getMonsters();
            List<IFighter> toRemove = new LinkedList<>();
            for (IFighter monster : monsters) {
                if (!monster.alive()) {
                    toRemove.add(monster);
                    world.getLevel().addMonsterKilled();
                } else {

                    monster.shoot();
                    monster.move();
                }
            }

            // Remove monster after iteration to handle concurrence in synchronised list
            for (IFighter monster : toRemove)
                monster.die();

            // Update nb moves in the same direction
            if (invertSpeed)
                nbMoveInSameDirection = 0;
            else
                nbMoveInSameDirection++;
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
                int margin = ((GamePlay.WIDTH - NB_MOVES_BEFORE_INVERT) / (level.getNbMonsterByWave()));
                for (int i = 1; i <= level.getNbMonsterByWave(); ++i) {
                    IFighter newMonster = level.generateMonster(new Location(0, 0));
                    int xAxisValue = (margin * i) - (margin / 2) - (newMonster.getImageWidth() / 2) + nbMoveInSameDirection;
                    newMonster.setLocation(new Location(xAxisValue, 0));
                    world.addMonster(newMonster);
                }
            }
        }
    }
}