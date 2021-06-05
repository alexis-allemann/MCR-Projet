package bullets;

import java.awt.*;

/**
 * Bullets used on fighters.spacecraft shoots
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface Bullet {
    /**
     * Get image
     *
     * @return the image
     */
    Image getImage();
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

    /**
     * Get position
     *
     * @return the position
     */
    Point getPosition();

    /**
     * Set position
     * @param point
     */
    void setPosition(Point point);
}
