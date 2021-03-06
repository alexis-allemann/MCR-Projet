package model.components.weapon;

import model.components.GameComponentWithHitBox;
import model.components.fighters.IFighter;
import utils.Utils;
import utils.physics.Speed;
import utils.physics.Location;

import java.awt.Image;

/**
 * Projectiles used on spacecraft shoots
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Projectile extends GameComponentWithHitBox {
    protected final int BASE_POWER = Integer.parseInt(Utils.getInstance().getProperty("PROJECTILE_BASE_POWER"));
    private final boolean isMonsterTeam;

    /**
     * Instantiation of a new bullet
     *
     * @param location      location of the projectile
     * @param imageName     filename of the bullet image
     * @param speed         of the bullet
     * @param isMonsterTeam if bullet is shot by a monster
     */
    public Projectile(Location location, String imageName, Speed speed, boolean isMonsterTeam) {
        super(location, imageName);
        this.speed = new Speed(speed.getX(), speed.getY());
        this.isMonsterTeam = isMonsterTeam;
    }

    /**
     * Instantiation of a new bullet
     *
     * @param image         filename of the bullet image
     * @param direction     of the bullet
     * @param isMonsterTeam if bullet is shot by a monster
     */
    public Projectile(String image, Speed direction, boolean isMonsterTeam) {
        super(new Location(0, 0), image);
        this.speed = new Speed(direction.getX(), direction.getY());
        this.isMonsterTeam = isMonsterTeam;
    }

    /**
     * Instantiation of a new bullet
     *
     * @param image         filename of the bullet image
     * @param speed         of the bullet
     * @param isMonsterTeam if bullet is shot by a monster
     */
    public Projectile(Image image, Speed speed, boolean isMonsterTeam) {
        super(new Location(0, 0), image);
        this.speed = new Speed(speed.getX(), speed.getY());
        this.isMonsterTeam = isMonsterTeam;
    }

    /**
     * Get bullet power
     *
     * @return the power
     */
    public int getPower() {
        return BASE_POWER;
    }

    /**
     * Get speed
     *
     * @return speed of the bullet
     */
    public Speed getSpeed() {
        return speed;
    }

    /**
     * Remove health to the fighter equal to the power of the bullet
     *
     * @param fighter fighter to remove health
     */
    public void hit(IFighter fighter) {
        fighter.removeHealth(getPower());
    }

    /**
     * Move bullet with as speed base added with speed of the bullet
     */
    public void move() {
        this.location.translate(speed.getX(), speed.getY());
    }

    /**
     * Check if fighter has the position where the bullet will be
     *
     * @param fighter Fighter Fighter to check position
     * @return True if there's a fighter to next location
     */
    public boolean checkNextLocation(IFighter fighter) {
        if (fighter.isMonsterTeam() == isMonsterTeam)
            return false;
        return checkHitBox(speed, fighter);
    }

    @Override
    public boolean isMonsterTeam() {
        return isMonsterTeam;
    }
}
