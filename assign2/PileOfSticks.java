/**
 * OOPJAVA - Assignment 2
 * Sebastian Lundström (selu7901)
 */

public class PileOfSticks
{
    protected Integer numSticks;

    public
    PileOfSticks(Integer numSticks)
    {
        Util.throwIfNull(numSticks);
        this.numSticks = numSticks;
    }

    public void
    removeSticks(Integer sticks)
    {
        numSticks -= sticks;
    }

    public Integer
    sticksLeft()
    {
        return numSticks;
    }
}
