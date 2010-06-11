class Move
{
    Integer numberOfSticks;

    public
    Move(Integer numberOfSticks)
    {
        Utils.throwIfNull(numberOfSticks);
        this.numberOfSticks = numberOfSticks;
    }

    public Integer
    sticks()
    {
        return numberOfSticks;
    }
}
