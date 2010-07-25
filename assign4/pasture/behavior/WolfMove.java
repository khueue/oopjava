/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class WolfMove implements IBehavior
{
    private IntervalTrigger trigger;

    public
    WolfMove()
    {
        trigger = new IntervalTrigger(8);
    }

    public void
    behave(IEntity entity)
    {
        if (trigger.fire())
        {
            List<Point> safe = entity.getPasture().getNearestSafePositions(entity, 1); // factor out XXX
            if (safe.size() > 0)
            {
                Point pos = Util.getRandomMember(safe);
                entity.getPasture().moveEntity(entity, pos);
            }
        }
    }
}
