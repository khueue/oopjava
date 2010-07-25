/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

public class IntervalTrigger
{
    private final Integer interval;
    private Integer delay;

    public
    IntervalTrigger(Integer interval)
    {
        delay = this.interval = interval;
    }

    public Boolean
    fire()
    {
        if (--delay == 0) // XXX pre or post?
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
