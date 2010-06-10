class PileOfSticks
{
    /*
    public static final Integer MAX_STICKS = 50;
    public static final Integer MIN_STICKS =  5;
    */

    protected Integer numberOfSticks;

    public
    PileOfSticks(Integer numberOfSticks)
    {
        this.setNumberOfSticks(numberOfSticks);
    }

    protected void
    setNumberOfSticks(Integer numberOfSticks)
    {
        Utils.throwIfNull(numberOfSticks);
        /*
        if (numberOfSticks < PileOfSticks.MIN_STICKS ||
            numberOfSticks > PileOfSticks.MAX_STICKS)
        {
            throw new IllegalArgumentException("Outside range!");
        }
        */
        this.numberOfSticks = numberOfSticks;
    }

    public void
    removeSticks(Integer sticks)
    {
        Utils.throwIfNull(sticks);
        this.numberOfSticks -= sticks;
    }

    public Integer
    half()
    {
        return this.numberOfSticks / 2;
    }

    public Integer
    sticksLeft()
    {
        return this.numberOfSticks;
    }
}
