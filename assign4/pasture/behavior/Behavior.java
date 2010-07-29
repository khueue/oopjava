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
        this.timer   = new RepeatingTimer(1); // Default: act on every tick.
    }

    public void
    setTriggerInterval(Integer interval)
    {
        timer.setInterval(interval);
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
        return entity.notRemoved() && timer.tickAndCheckIfAlarm();
    }

    abstract protected void
    triggerAct();
}
