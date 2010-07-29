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
        behaviors.add(new WolfMove(this));
        behaviors.add(new WolfEat(this));
        behaviors.add(new WolfReproduce(this));
    }

    public IEntity
    spawnChild()
    {
        return new Wolf(pasture);
    }

    public Boolean
    maySharePositionWith(IEntity entity)
    {
        return (entity instanceof Grass)
            || (entity instanceof Sheep);
    }
}
