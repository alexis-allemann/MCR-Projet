package model.components.fighters.decorators;

import model.World;
import model.components.fighters.IFighter;
import utils.Utils;

import java.awt.*;

/**
 * Shield to protect model.components.fighters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Shield extends FighterDecorator {
    private int shieldPower;

    /**
     * Instantiation of a new shield
     *
     * @param fighter     to decorate
     * @param shieldPower power of the shield
     */
    public Shield(IFighter fighter, int shieldPower) {
        super(fighter);
        this.shieldPower = shieldPower;
    }

    @Override
    public void removeHealth(int hp) {
        shieldPower -= hp;
        if (shieldPower <= 0) {
            fighter.removeHealth(shieldPower);
            removeDecoration();
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Image image = Utils.getInstance().getImageFromResources("Shield.png");
        graphics2D.drawImage(image, fighter.getLocation().getIntX(), fighter.getLocation().getIntY(), null);
    }
}