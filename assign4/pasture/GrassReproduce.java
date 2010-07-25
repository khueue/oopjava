/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;

public class GrassReproduce implements IBehavior
{
    private IntervalTrigger trigger;

    public
    GrassReproduce()
    {
        trigger = new IntervalTrigger(10);
    }

    public void
    behave(IEntity entity)
    {
        if (trigger.fire())
        {
            List<Point> safe = entity.getPasture().getNearestSafePositions(entity, 1);
            if (safe.size() > 0)
            {
                Point pos = Util.getRandomMember(safe);
                IEntity offspring = new Grass(entity.getPasture());
                entity.getPasture().addEntity(offspring, pos);
            }
        }
    }
}
