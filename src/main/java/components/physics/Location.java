package components.physics;

import java.awt.geom.Point2D;

public class Location extends Point2D.Float{

    public Location(float x, float y){
        super(x, y);
    }

    public void translate(float dx, float dy){
        this.x += dx;
        this.y += dy;
    }
}
