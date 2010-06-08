/**
 *
 */
class Move
{
    Integer numberOfSticks = null;

    public
    Move(Integer numberOfSticks)
    {
        if (numberOfSticks == null)
        {
            throw new IllegalArgumentException("Must not be null!");
        }
        this.numberOfSticks = numberOfSticks;
    }
}
