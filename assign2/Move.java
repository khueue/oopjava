class Move
{
    Integer numSticks;

    public
    Move(Integer numSticks)
    {
        Utils.throwIfNull(numSticks);
        this.numSticks = numSticks;
    }

    public Integer
    sticks()
    {
        return numSticks;
    }
}
