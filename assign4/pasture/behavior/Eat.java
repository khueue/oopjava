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
    public
    Eat(IEntity entity)
    {
        super(entity);
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
                victim.remove();
            }
        }
    }

    abstract public Boolean
    mayEat(IEntity entity);
}
