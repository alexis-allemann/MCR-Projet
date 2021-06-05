package fighters.decorators;

import fighters.Fighter;

/**
 * Shield to protect fighters
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
    public Shield(Fighter fighter) {
        super(fighter);
    }
}