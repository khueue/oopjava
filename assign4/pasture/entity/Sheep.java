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
        addBehavior(new SheepMove(this));
        addBehavior(new SheepEat(this));
        addBehavior(new SheepReproduce(this));
    }

    public Boolean
    maySharePositionWith(IEntity entity)
    {
        return (entity instanceof Grass);
    }
}
