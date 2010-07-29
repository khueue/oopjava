/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

abstract public class Move extends Behavior
{
    private RepeatingTimer timer;

    public
    Move(IEntity entity, Integer interval)
    {
        super(entity);
        this.timer = new RepeatingTimer(interval);
    }

    public Boolean
    timeToAct()
    {
        return timer.tickAndCheckIfAlarm();
    }

    public void
    act()
    {
        if (entity.notRemoved() && timeToAct())
        {
            List<Point> safe = pasture.getNearestSafePositions(entity, 1);
            if (!safe.isEmpty())
            {
                Point pos = Util.getRandomMember(safe);
                pasture.moveEntity(entity, pos);
            }
        }
    }
}
