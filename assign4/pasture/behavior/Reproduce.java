/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

abstract public class Reproduce extends Behavior
{
    public
    Reproduce(IEntity entity)
    {
        super(entity);
    }

    public void
    triggerAct()
    {
        List<Point> safe = pasture.getNearestSafePositions(entity, 1);
        if (!safe.isEmpty())
        {
            Point pos = Util.getRandomMember(safe);
            IEntity offspring = entity.spawnChild();
            pasture.addEntity(offspring, pos);
        }
    }
}
