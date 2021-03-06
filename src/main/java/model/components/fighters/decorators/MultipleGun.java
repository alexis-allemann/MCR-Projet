package model.components.fighters.decorators;

import utils.physics.Direction;
import model.components.fighters.IFighter;
import model.components.weapon.IWeapon;
import model.components.weapon.Weapon;
import model.components.weapon.Projectile;
import utils.Utils;
import utils.physics.Speed;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 * Make fighters shoots multiple time
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class MultipleGun extends FighterDecorator {
    private static final int MAX_COUNT = Integer.parseInt(Utils.getInstance().getProperty("NB_MAX_MULTIPLE_GUN"));
    private final List<IWeapon> WEAPONS = new ArrayList<>();
    private final long START = System.currentTimeMillis();
    private final int TIME_IN_SECONDS;
    private int nbGet = 0;

    /**
     * Instantiation of a new decoration
     *
     * @param fighter           to decorate
     * @param nbParallelsShoots additional shoots
     * @param timeInSeconds     time of the bonus
     */
    public MultipleGun(final IFighter fighter, int nbParallelsShoots, int timeInSeconds) {
        super(fighter);
        this.TIME_IN_SECONDS = timeInSeconds;
        if (fighter.countDecorator(getClass()) > MAX_COUNT - 1)
            removeDecoration();
        else {
            for (int i = 0; i < nbParallelsShoots; ++i) {
                final int x = (nbParallelsShoots / 2) - nbParallelsShoots + i;
                Weapon newWeapon = new Weapon() {
                    @Override
                    public Projectile getBullet(Direction direction) {
                        float y = direction == Direction.TOP ? -10f : 10f;
                        return new Projectile("laser.png", new Speed(x, y), getFighter().isMonsterTeam()) {
                            @Override
                            public int getPower() {
                                return 100;
                            }
                        };
                    }

                    @Override
                    public int reloadTimeInMilliSeconds() {
                        return 500;
                    }
                };
                newWeapon.setFighter(this);
                WEAPONS.add(newWeapon);
            }
        }
    }

    @Override
    public void shoot() {
        long current = System.currentTimeMillis();
        if (current - START <= TIME_IN_SECONDS * 1000L) {
            for (IWeapon weapon : WEAPONS) weapon.shoot();
        } else
            removeDecoration();
    }

    @Override
    public IWeapon getWeapon() {
        IWeapon weapon = WEAPONS.get(nbGet);
        if (++nbGet == WEAPONS.size())
            nbGet = 0;
        return weapon;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("multiple.png");
        graphics2D.drawImage(image, fighter.getLocation().getIntX(), fighter.getLocation().getIntY(), null);
    }
}
