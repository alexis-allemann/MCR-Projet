package components.fighters.decorators;

import components.fighters.GameComponent;

import java.awt.Image;

/**
 * Shield to protect components.fighters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Shield extends FighterDecorator {

    /**
     * Instantiation of a new shield
     *
     * @param fighter to decorate
     */
    public Shield(GameComponent fighter) {
        super(fighter);
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public boolean exist() {
        return true;
    }
}