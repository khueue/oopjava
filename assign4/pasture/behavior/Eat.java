/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

abstract public class Eat implements IBehavior
{
    public void
    act(IEntity entity)
    {
        Pasture pasture = entity.getPasture();
        List<IEntity> victims = pasture.getOtherEntitiesAtSamePosition(entity);
        for (IEntity victim : victims)
        {
            if (mayEat(victim))
            {
                // get food points also XXXXX
                pasture.removeEntity(victim);
            }
        }
    }

    abstract public Boolean
    mayEat(IEntity entity);
}
