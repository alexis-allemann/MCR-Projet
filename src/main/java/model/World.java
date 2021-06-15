package model;

import levels.Beginner;
import levels.Level;
import model.components.fighters.Fighter;
import model.components.fighters.SpaceCraft;
import model.components.physics.Location;
import model.components.weapon.StandardWeapon;
import model.components.weapon.bullets.Bullet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * World state representation
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class World {
    private static final World instance = new World();
    private final List<Fighter> monsters = Collections.synchronizedList(new ArrayList<>());
    private final List<Bullet> bullets = Collections.synchronizedList(new ArrayList<>());
    private final Fighter spacecraft = new SpaceCraft(new Location(0, 0));
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
        return instance;
    }

    /**
     * Get the spacecraft
     *
     * @return the spacecraft
     */
    public Fighter getSpacecraft() {
        return spacecraft;
    }

    /**
     * Get all monsters
     *
     * @return the list of all monsters
     */
    public List<Fighter> getMonsters() {
        return monsters;
    }

    /**
     * Add a monster to the world
     *
     * @param monster the monster to add
     */
    public void addMonster(Fighter monster) {
        monsters.add(monster);
    }

    /**
     * Remove a monster from the world
     */
    public void removeMonster(Fighter monster) {
        monsters.remove(monster);
    }

    /**
     * Get all monsters
     *
     * @return the list of all monsters
     */
    public List<Bullet> getBullets() {
        return bullets;
    }

    /**
     * Add a bullet to the world
     *
     * @param bullet the monster to add
     */
    public void addBullet(Bullet bullet) {
        bullets.add(bullet);
    }

    /**
     * Remove a bullet from the world
     */
    public void removeBullet(Bullet bullet) {
        bullets.remove(bullet);
    }

    /**
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
}
