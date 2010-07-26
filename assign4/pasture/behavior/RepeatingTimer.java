/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

public class RepeatingTimer
{
    private final Integer interval;
    private Integer delay;

    public
    RepeatingTimer(Integer interval)
    {
        delay = this.interval = interval;
    }

    public Boolean
    stepAndCheck()
    {
        if (--delay == 0)
        {
            delay = interval;
            return true;
        }
        else
        {
            return false;
        }
    }
}
