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
    protected RepeatingTimer starveTimer;

    public
    Eat(IEntity entity)
    {
        super(entity);
        starveTimer = new RepeatingTimer(0); // Default: never starve.
    }

    public void
    starveAfter(Integer period)
    {
        starveTimer.ringAfter(period);
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
            triggerAct();
        }
    }

    protected Boolean
    starvesToDeath()
    {
        return entity.notRemoved() && starveTimer.tickAndCheckIfRinging();
    }

    public void
    triggerAct()
    {
        List<IEntity> victims = pasture.getOtherEntitiesAtSamePosition(entity);
        for (IEntity victim : victims)
        {
            if (mayEat(victim))
            {
                // get food points also XXXXX
                victim.die();
            }
        }
    }

    abstract public Boolean
    mayEat(IEntity entity);
}
