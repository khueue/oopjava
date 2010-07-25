/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class SheepEat implements IBehavior
{
    public void
    behave(IEntity entity)
    {
        List<IEntity> victims = entity.getPasture().getOtherEntitiesAtSamePosition(entity);
        for (IEntity victim : victims)
        {
            if (mayEat(victim))
            {
                // get food points also XXXXX
                entity.getPasture().removeEntity(victim);
            }
        }
    }

    private Boolean
    mayEat(IEntity entity)
    {
        return (entity instanceof Grass);
    }
}
