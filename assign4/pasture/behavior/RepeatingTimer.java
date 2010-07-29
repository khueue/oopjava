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
        setInterval(interval);
    }

    public void
    setInterval(Integer interval)
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
        --now;
    }

    private Boolean
    alarm()
    {
        return now == 0;
    }

    private void
    reset()
    {
        now = interval;
    }
}
