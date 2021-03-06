package model;

import controllers.GameController;
import model.levels.Beginner;
import model.levels.Level;
import model.components.fighters.IFighter;
import model.components.fighters.SpaceCraft;
import model.components.weapon.Projectile;
import utils.physics.Location;
import model.components.weapon.StandardWeapon;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

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
    private IFighter spacecraft = new SpaceCraft(new Location(0, 0));
    private Level level;
    private boolean isRunning;

    /**
     * Instantiation of the world (private to apply Singleton pattern)
     */
    private World() {
        spacecraft.setWeapon(new StandardWeapon());
        spacecraft.setWeapon(spacecraft.getWeapon());
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
     * Set spacecraft
     *
     * @param spacecraft to set
     */
    public void setSpacecraft(IFighter spacecraft) {
        this.spacecraft = spacecraft;
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
     * @param monster to add or replace
     */
    public void replaceOrAddMonster(final IFighter monster) {
        int index = monsters.indexOf(monster);
        if (index != -1)
            monsters.set(index, monster);
        else
            addMonster(monster);
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
     * Get if a game is running
     *
     * @return if a game is running
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Set if the game is running
     *
     * @param isRunning if the game is running
     */
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    /**
     * Reset world
     */
    public void reset() {
        monsters.clear();
        projectiles.clear();
        spacecraft = new SpaceCraft(new Location(0, 0));
        resetSpaceCraftLocation();
        spacecraft.setWeapon(new StandardWeapon());
        level = new Beginner();
        isRunning = true;
    }

    /**
     * Reset default location of the spacecraft
     */
    private void resetSpaceCraftLocation() {
        IFighter spacecraft = World.getInstance().getSpacecraft();
        spacecraft.setLocation(new Location(
                (GameController.WIDTH - spacecraft.getImageWidth()) / 2.f,
                GameController.HEIGHT - spacecraft.getImageHeight() - GameController.INFO_PANEL_HEIGHT
        ));
    }
}
