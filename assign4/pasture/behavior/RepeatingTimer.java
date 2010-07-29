/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

public class RepeatingTimer
{
    private Integer interval;
    private Integer now;

    public
    RepeatingTimer(Integer interval)
    {
        ringAfter(interval);
    }

    public void
    ringAfter(Integer interval)
    {
        this.interval = interval;
        reset();
    }

    public Boolean
    tickAndCheckIfRinging()
    {
        tick();
        if (ringing())
        {
            reset();
            return true;
        }
        return false;
    }

    public void
    tick()
    {
        --now;
    }

    public Boolean
    ringing()
    {
        return now == 0;
    }

    public void
    reset()
    {
        now = interval;
    }
}
