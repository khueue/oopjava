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
    protected RepeatingTimer timer = new RepeatingTimer();

    public
    Behavior(IEntity entity)
    {
        this.entity  = entity;
        this.pasture = entity.getPasture();
        alwaysTrigger();
    }

    protected void
    triggerAfter(Integer period)
    {
        timer.ringAfter(period);
    }

    protected void
    alwaysTrigger()
    {
        timer.ringAfter(RepeatingTimer.ALWAYS_RING);
    }

    protected void
    neverTrigger()
    {
        timer.ringAfter(RepeatingTimer.NEVER_RING);
    }

    public void
    act()
    {
        if (shouldAct())
        {
            actNow();
        }
    }

    protected Boolean
    shouldAct()
    {
        return entity.notRemoved() && timer.tickAndCheckIfRinging();
    }

    abstract protected void
    actNow();
}
