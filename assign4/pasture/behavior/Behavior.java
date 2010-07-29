/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import pasture.*;
import pasture.entity.*;

abstract public class Behavior implements IBehavior
{
    protected IEntity entity;
    protected Pasture pasture;

    public
    Behavior(IEntity entity)
    {
        this.entity  = entity;
        this.pasture = entity.getPasture();
    }
}
