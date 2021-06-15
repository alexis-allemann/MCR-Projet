package model.components.weapon;

import controllers.Direction;
import utils.Utils;
import utils.physics.Vector2D;
import model.components.weapon.bullets.Bullet;

public class BombWeapon extends Weapon {
    @Override
    Bullet getBullet(Direction direction) {
        return new Bullet("bomb.png", new Vector2D(Utils.getInstance().randomFloat(-1, 1), 0.8f), getFighter().isMonsterTeam()) {
            @Override
            public int getBaseSpeed() {
                return super.getBaseSpeed();
            }

            @Override
            public int getPower() {
                return super.getPower();
            }
        };
    }

    @Override
    int reloadTimeInMilliSeconds() {
        return 5000;
    }
}
