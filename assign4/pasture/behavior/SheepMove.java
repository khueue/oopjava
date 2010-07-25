/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class SheepMove implements IBehavior
{
    private IntervalTrigger trigger;

    public
    SheepMove()
    {
        trigger = new IntervalTrigger(8);
    }

    public void
    behave(IEntity entity)
    {
        if (trigger.fire())
        {
            Pasture pasture = entity.getPasture();
            List<Point> safe = pasture.getNearestSafePositions(entity, 1);
            if (!safe.isEmpty())
            {
                Point pos = Util.getRandomMember(safe);
                pasture.moveEntity(entity, pos);
            }
        }
    }
}
