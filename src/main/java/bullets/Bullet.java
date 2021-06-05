package bullets;

/**
 * Bullets used on fighters.spacecraft shoots
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface Bullet {

    /**
     * Get bullet speed
     *
     * @return the speed
     */
    int getSpeed();

    /**
     * Get bullet power
     *
     * @return the power
     */
    int getPower();
}
