class PileOfSticks
{
    protected Integer numberOfSticks;

    public
    PileOfSticks(Integer numberOfSticks)
    {
        Utils.throwIfNull(numberOfSticks);
        this.numberOfSticks = numberOfSticks;
    }

    public void
    removeSticks(Integer sticks)
    {
        numberOfSticks -= sticks;
    }

    public Integer
    sticksLeft()
    {
        return numberOfSticks;
    }
}
