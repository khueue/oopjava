/**
 * OOPJAVA - Assignment 2
 * Sebastian Lundström (selu7901)
 */

public class Move
{
    Integer numSticks;

    public
    Move(Integer numSticks)
    {
        Util.throwIfNull(numSticks);
        this.numSticks = numSticks;
    }

    public Integer
    sticks()
    {
        return numSticks;
    }
}
