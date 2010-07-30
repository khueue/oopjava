/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import pasture.*;
import pasture.entity.*;

abstract public class Behavior implements IBehavior
{
    protected IEntity entity;
    protected Pasture pasture;
    protected RepeatingTimer timer;

    public
    Behavior(IEntity entity)
    {
        this.entity  = entity;
        this.pasture = entity.getPasture();
        this.timer   = new RepeatingTimer(1); // 1 == ring on each tick.
    }

    public void
    setTriggerPeriod(Integer period)
    {
        timer.ringAfter(period);
    }

    public void
    act()
    {
        if (shouldAct())
        {
            triggerAct();
        }
    }

    protected Boolean
    shouldAct()
    {
        return entity.notRemoved() && timer.tickAndCheckIfRinging();
    }

    abstract protected void
    triggerAct();
}
