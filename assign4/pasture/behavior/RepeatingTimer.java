/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

public class RepeatingTimer
{
    private final Integer interval;
    private Integer time;

    public
    RepeatingTimer(Integer interval)
    {
        this.interval = interval;
        reset();
    }

    public Boolean
    tickAndCheckIfAlarm()
    {
        tick();
        if (alarm())
        {
            reset();
            return true;
        }
        return false;
    }

    private void
    tick()
    {
        --time;
    }

    private Boolean
    alarm()
    {
        return time == 0;
    }

    private void
    reset()
    {
        time = interval;
    }
}
