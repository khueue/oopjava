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
    tickAndCheckAlarm()
    {
        decrease();
        if (alarm())
        {
            reset();
            return true;
        }
        return false;
    }

    private void
    decrease()
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
        time = this.interval;
    }
}
