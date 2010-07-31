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
        triggerAlways();
    }

    public void
    triggerAfter(Integer period)
    {
        timer.ringAfter(period);
    }

    public void
    triggerAlways()
    {
        timer.ringAfter(RepeatingTimer.ALWAYS_RING);
    }

    public void
    triggerNever()
    {
        timer.ringAfter(RepeatingTimer.NEVER_RING);
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
