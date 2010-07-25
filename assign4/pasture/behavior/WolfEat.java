/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class WolfEat implements IBehavior
{
    public void
    behave(IEntity entity)
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

    private Boolean
    mayEat(IEntity entity)
    {
        return (entity instanceof Sheep);
    }
}
