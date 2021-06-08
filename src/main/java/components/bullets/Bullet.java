package components.bullets;

import components.GameComponent;
import components.fighters.Fighter;
import components.physics.Speed;
import components.physics.Location;

/**
 * Bullets used on components.fighters.spacecraft shoots
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Bullet extends GameComponent {

    static final Speed BASE_SPEED = new Speed(0.f, -10.f);
    final int BASE_POWER = 1;
    protected boolean alive = true;
    protected Speed speed;

    /**
     * Instantiation of a new bullet
     *
     * @param location point where the shoot is located
     * @param image    filename of the bullet image
     */
    public Bullet(Location location, String image) {
        super(location, image);
        this.speed = BASE_SPEED;
    }

    /**
     * Get bullet speed
     *
     * @return the speed
     */
    abstract Speed getSpeed();

    /**
     * Get bullet power
     *
     * @return the power
     */
    abstract int getPower();

    /**
     * Remove health to the fighter equal to the power of the bullet
     *
     * @param fighter fighter to remove health
     */
    public abstract void hit(Fighter fighter);

    /**
     * Move bullet with as speed base added with speed of the bullet
     */
    public void move(){
        this.location.translate(speed.getX(), speed.getY());
    };

    /**
     * Check if fighter has the position where the bullet will be
     * @param fighter Fighter Fighter to check position
     * @return True if there's a fighter to next location
     */
    public boolean checkNextLocation(Fighter fighter){
        // TODO mettre une hitbox
        return fighter.getLocation().equals(new Location(getLocation().x +getSpeed().getX(), getLocation().y + getSpeed().getY()));
    }

    @Override
    public boolean exist() {
        return alive;
    }
}
