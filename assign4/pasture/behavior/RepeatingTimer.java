/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

public class RepeatingTimer
{
    private Integer period;
    private Integer now;

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
