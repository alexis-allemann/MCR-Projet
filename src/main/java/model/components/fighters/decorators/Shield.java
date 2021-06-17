package model.components.fighters.decorators;

import model.World;
import model.components.fighters.IFighter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

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
        if (shieldPower < 0)
            fighter.removeHealth(hp);
        World world = World.getInstance();
        world.setSpacecraft(world.getSpacecraft().removeDecorator(this));
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        try { // TODO : Fonction dans utils pour load une image
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            Image image = ImageIO.read(Objects.requireNonNull(classloader.getResource("Shield.png")));
            graphics2D.drawImage(image, fighter.getLocation().getIntX(), fighter.getLocation().getIntY(), null);
        } catch (IOException e) {
            System.out.println("Component image has not been found in resources");
        }
    }
}