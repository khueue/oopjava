/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.entity;

import pasture.*;
import pasture.behavior.*;

public class Wolf extends Entity
{
    public
    Wolf(Pasture pasture)
    {
        super(pasture, "img/wolf.gif");
        behaviors.add(new WolfMove());
        behaviors.add(new WolfEat());
        behaviors.add(new WolfReproduce());
    }

    public Boolean
    maySharePositionWith(IEntity entity)
    {
        return (entity instanceof Grass)
            || (entity instanceof Sheep);
    }
}
