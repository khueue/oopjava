public class PileOfSticks
{
    protected Integer numSticks;

    public
    PileOfSticks(Integer numSticks)
    {
        Utils.throwIfNull(numSticks);
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
