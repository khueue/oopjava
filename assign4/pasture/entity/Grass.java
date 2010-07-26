/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.entity;

import pasture.*;
import pasture.behavior.*;

public class Grass extends Entity
{
    public
    Grass(Pasture pasture)
    {
        super(pasture, "img/plant.gif");
        behaviors.add(new GrassReproduce());
    }

    public Boolean
    maySharePositionWith(IEntity entity)
    {
        return (entity instanceof Wolf)
            || (entity instanceof Sheep);
    }
}
