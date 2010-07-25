/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;

public class WolfReproduce implements IBehavior
{
    private IntervalTrigger trigger;

    public
    WolfReproduce()
    {
        trigger = new IntervalTrigger(201);
    }

    public void
    behave(Entity entity)
    {
        if (trigger.fire())
        {
            List<Point> safe = entity.getPasture().getNearestSafePositions(entity, 1);
            if (safe.size() > 0)
            {
                Point pos = Util.getRandomMember(safe);
                Entity offspring = new Wolf(entity.getPasture());
                entity.getPasture().addEntity(offspring, pos);
            }
        }
    }
}
