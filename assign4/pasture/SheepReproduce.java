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
    behave(Entity entity)
    {
        if (trigger.fire())
        {
            List<Point> safe = entity.getPasture().getNearestSafePositions(entity, 1);
            if (safe.size() > 0)
            {
                Point pos = Util.getRandomMember(safe);
                Entity offspring = new Sheep(entity.getPasture());
                entity.getPasture().addEntity(offspring, pos);
            }
        }
    }

    /** /
    private Entity
    createOwnInstance() // clone in Entity? wolfs construcotor runs own news for behav
    {
        try
        {
            Class[] argTypes = new Class[] { pasture.getClass() };
            Constructor constructor = getClass().getConstructor(argTypes);
            Object[] args = new Object[] { pasture };
            return (Entity)constructor.newInstance(args);
        }
        catch (Exception e)
        {
            return null;
        }
    }
    /**/
}
