/**
 *
 */
class PileOfSticks
{
    public static final int MAX_STICKS = 100;
    public static final int MIN_STICKS =   5;

    protected Integer numberOfSticksLeft = null;

    public
    PileOfSticks(Integer numberOfSticks)
    {
        this.setNumberOfSticks(numberOfSticks);
    }

    protected void
    setNumberOfSticks(Integer numberOfSticks)
    {
        if (numberOfSticks == null)
        {
            throw new IllegalArgumentException("Must not be null!");
        }
        if (numberOfSticks < PileOfSticks.MIN_STICKS ||
            numberOfSticks > PileOfSticks.MAX_STICKS)
        {
            throw new IllegalArgumentException("Outside range!");
        }
        this.numberOfSticksLeft = numberOfSticks;
    }

    public Integer
    sticksLeft()
    {
        return this.numberOfSticksLeft;
    }
}
