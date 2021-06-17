package model.components;

import model.components.fighters.IFighter;
import model.components.fighters.decorators.FighterDecorator;
import model.components.weapon.IWeapon;
import model.components.weapon.decorators.WeaponDecorator;

public interface IDecoratorFactory {
    FighterDecorator createFighterDecorator(IFighter fighter);
    WeaponDecorator createWeaponDecorator(IWeapon weapon);
}
