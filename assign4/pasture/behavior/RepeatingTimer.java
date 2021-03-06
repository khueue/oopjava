/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

public class RepeatingTimer
{
    public static final Integer NEVER_RING  = 0;
    public static final Integer ALWAYS_RING = 1;

    private Integer period;
    private Integer now;

    public
    RepeatingTimer()
    {
        ringAfter(NEVER_RING);
    }

    public
    RepeatingTimer(Integer period)
    {
        ringAfter(period);
    }

    public void
    ringAfter(Integer period)
    {
        this.period = period;
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
        now = period;
    }
}
