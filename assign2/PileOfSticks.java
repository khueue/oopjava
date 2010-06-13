class PileOfSticks
{
    protected Integer numberOfSticks;

    public
    PileOfSticks(Integer numberOfSticks)
    {
        setNumberOfSticks(numberOfSticks);
    }

    protected void
    setNumberOfSticks(Integer numberOfSticks)
    {
        Utils.throwIfNull(numberOfSticks);
        this.numberOfSticks = numberOfSticks;
    }

    public void
    removeSticks(Integer sticks)
    {
        Utils.throwIfNull(sticks);
        numberOfSticks -= sticks;
    }

    public Integer
    half()
    {
        return numberOfSticks / 2;
    }

    public Integer
    sticksLeft()
    {
        return numberOfSticks;
    }
}
