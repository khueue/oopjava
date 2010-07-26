/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

abstract public class Move implements IBehavior
{
    private RepeatingTimer timer;

    public
    Move(Integer interval)
    {
        timer = new RepeatingTimer(interval);
    }

    public Boolean
    timeToAct()
    {
        return timer.stepAndCheck();
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
                pasture.moveEntity(entity, pos);
            }
        }
    }
}
