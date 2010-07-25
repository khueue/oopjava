/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;

public class SheepReproduce implements IBehavior
{
    private IntervalTrigger trigger;

    public
    SheepReproduce()
    {
        trigger = new IntervalTrigger(101);
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
                IEntity offspring = new Sheep(entity.getPasture());
                entity.getPasture().addEntity(offspring, pos);
            }
        }
    }
}
