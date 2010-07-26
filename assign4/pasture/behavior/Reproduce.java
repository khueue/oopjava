/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

abstract public class Reproduce implements IBehavior
{
    private IntervalTrigger trigger;

    public
    Reproduce(Integer interval)
    {
        trigger = new IntervalTrigger(interval);
    }

    public Boolean
    timeToAct()
    {
        return trigger.step();
    }

    public void
    act(IEntity entity)
    {
        if (timeToAct())
        {
            Pasture pasture = entity.getPasture();
            List<Point> safe = pasture.getNearestSafePositions(entity, 1);
            if (!safe.isEmpty())
            {
                Point pos = Util.getRandomMember(safe);
                IEntity offspring = entity.spawnChild();
                pasture.addEntity(offspring, pos);
            }
        }
    }
}
