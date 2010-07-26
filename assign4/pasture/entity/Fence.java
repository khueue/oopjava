/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.entity;

import pasture.*;
import pasture.behavior.*;

public class Fence extends Entity
{
    public
    Fence(Pasture pasture)
    {
        super(pasture, "img/fence.gif");
    }

    public IEntity
    spawnChild()
    {
        return new Fence(pasture);
    }

    public Boolean
    maySharePositionWith(IEntity entity)
    {
        return false;
    }
}
