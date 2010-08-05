/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

abstract public class Eat extends Behavior
{
    protected RepeatingTimer starvationTimer;

    public
    Eat(IEntity entity)
    {
        super(entity);
        alwaysTrigger();
        starvationTimer = new RepeatingTimer(RepeatingTimer.NEVER_RING);
    }

    protected void
    starveAfter(Integer period)
    {
        starvationTimer.ringAfter(period);
    }

    public void
    act()
    {
        if (starvesToDeath())
        {
            entity.die();
        }
        else if (shouldAct())
        {
            actNow();
        }
    }

    protected Boolean
    starvesToDeath()
    {
        return entity.notRemoved() && starvationTimer.tickAndCheckIfRinging();
    }

    protected void
    actNow()
    {
        List<IEntity> victims = pasture.getOtherEntitiesAtSamePosition(entity);
        for (IEntity victim : victims)
        {
            if (mayEat(victim))
            {
                starvationTimer.reset();
                victim.die();
            }
        }
    }

    abstract protected Boolean
    mayEat(IEntity entity);
}
