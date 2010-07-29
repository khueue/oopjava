/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.entity;

import pasture.*;
import pasture.behavior.*;

public class Sheep extends Entity
{
    public
    Sheep(Pasture pasture)
    {
        super(pasture, "img/sheep.gif");
        behaviors.add(new SheepMove(this));
        behaviors.add(new SheepEat(this));
        behaviors.add(new SheepReproduce(this));
    }

    public IEntity
    spawnChild()
    {
        return new Sheep(pasture);
    }

    public Boolean
    maySharePositionWith(IEntity entity)
    {
        return (entity instanceof Grass);
    }
}
