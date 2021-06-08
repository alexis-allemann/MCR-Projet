package components;

/**
 * Health for a fighter
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Health {
    private int health;

    /**
     * Instantiation of a fighter's health
     *
     * @param health base health
     */
    public Health(int health) {
        this.health = health;
    }

    /**
     * Removing healing points to the fighter's health
     * @param hp healing points to remove
     */
    public void removeHealth(int hp){
        health -= hp;
    }

    /**
     * Get Health's healing point
     * @return healing point
     */
    public int getHP() {
        return health;
    }
}
