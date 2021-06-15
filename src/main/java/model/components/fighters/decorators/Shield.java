package model.components.fighters.decorators;

import model.World;
import model.components.fighters.Fighter;

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
    public Shield(Fighter fighter, int shieldPower) {
        super(fighter);
        this.shieldPower = shieldPower;
    }

    @Override
    public void removeHealth(int hp) {
        shieldPower -= hp;
        if (shieldPower < 0)
            fighter.removeHealth(hp);
        World world = World.getInstance();
        world.setSpacecraft(world.getSpacecraft().removeDecorator(this));
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        graphics2D.setColor(Color.red);
        graphics2D.fillRect(fighter.getLocation().getIntX(), fighter.getLocation().getIntY(), 20, 20);
    }
}