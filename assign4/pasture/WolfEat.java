/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;

public class WolfEat implements IBehavior
{
    public void
    behave(Entity entity)
    {
        List<Entity> victims = entity.getPasture().getOtherEntitiesAtSamePosition(entity);
        for (Entity victim : victims)
        {
            if (entity.mayEat(victim))
            {
                // get food points also XXXXX
                entity.getPasture().removeEntity(victim);
            }
        }
    }
}
