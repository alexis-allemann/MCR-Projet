package model.components.fighters.decorators;

import model.components.fighters.Fighter;

/**
 * Make model.components.fighters shoots multiple times
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class MultipleShoot extends FighterDecorator {

    private final int additionalShootsNumber;

    /**
     * Instantiation of a new decoration
     *
     * @param fighter                to decorate
     * @param additionalShootsNumber additional shoots
     */
    public MultipleShoot(Fighter fighter, int additionalShootsNumber) {
        super(fighter);
        this.additionalShootsNumber = additionalShootsNumber;
    }

    @Override
    public void shoot() {
        super.shoot();

        for (int i = 0; i < additionalShootsNumber; i++) {
            super.shoot();
        }
    }
}
