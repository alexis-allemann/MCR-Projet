package model;

import model.components.fighters.decorators.Shield;
import model.levels.Beginner;
import model.levels.Level;
import model.components.fighters.IFighter;
import model.components.fighters.SpaceCraft;
import model.components.weapon.Projectile;
import utils.physics.Location;
import model.components.weapon.StandardWeapon;

import java.util.*;

/**
 * World state representation
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class World {
    private static final World INSTANCE = new World();
    private final List<IFighter> monsters = Collections.synchronizedList(new ArrayList<IFighter>());
    private final List<Projectile> projectiles = Collections.synchronizedList(new ArrayList<Projectile>());
    private IFighter spacecraft = new Shield(new SpaceCraft(new Location(0, 0)), 1);
    private Level level;

    /**
     * Instantiation of the world (private to apply Singleton pattern)
     */
    private World() {
        spacecraft.setWeapon(new StandardWeapon());
        this.level = new Beginner();
    }

    /**
     * Get instance of the world to implement singleton pattern
     *
     * @return the instance of the world
     */
    public static World getInstance() {
        return INSTANCE;
    }

    /**
     * Get the spacecraft
     *
     * @return the spacecraft
     */
    public IFighter getSpacecraft() {
        return spacecraft;
    }

    /**
     * Get all monsters
     *
     * @return the list of all monsters
     */
    public List<IFighter> getMonsters() {
        return monsters;
    }

    /**
     * Add a monster to the world
     *
     * @param monster the monster to add
     */
    public void addMonster(IFighter monster) {
        monsters.add(monster);
    }

    /**
     * Add or replace a monster in the world
     *
     * @param fighter to add or replace
     */
    public void replaceOrAddMonster(final IFighter fighter) {
        int index = monsters.indexOf(fighter);
        if (index != -1)
            monsters.set(index, fighter);
        else
            addMonster(fighter);
    }

    /**
     * Remove a monster from the world
     *
     * @param monster to remove
     */
    public void removeMonster(IFighter monster) {
        Iterator it = monsters.listIterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), monster)) {
                it.remove();
            }
        }
    }

    /**
     * Get all monsters
     *
     * @return the list of all monsters
     */
    public List<Projectile> getBullets() {
        return projectiles;
    }

    /**
     * Add a bullet to the world
     *
     * @param projectile the monster to add
     */
    public void addBullet(Projectile projectile) {
        projectiles.add(projectile);
    }

    /**
     * Remove a bullet from the world
     *
     * @param projectile to remove
     */
    public void removeBullet(Projectile projectile) {
        projectiles.remove(projectile);
    }

    /**
     * Get the current level
     *
     * @return the current level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Set the level of the world
     *
     * @param level to set
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Set spacecraft
     *
     * @param spacecraft to set
     */
    public void setSpacecraft(IFighter spacecraft) {
        this.spacecraft = spacecraft;
    }
}
