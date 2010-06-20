public class Rules
{
    protected PileOfSticks pile;

    public
    Rules(PileOfSticks pile)
    {
        Util.throwIfNull(pile);
        this.pile = pile;
    }

    public Boolean
    isIllegalMove(Move move)
    {
        Boolean tooFew  = move.sticks() < minAllowedSticks();
        Boolean tooMany = move.sticks() > maxAllowedSticks();
        return tooFew || tooMany;
    }

    public Integer
    minAllowedSticks()
    {
        return 1;
    }

    public Integer
    maxAllowedSticks()
    {
        return pile.sticksLeft() / 2;
    }

    public Boolean
    isGameOver()
    {
        return pile.sticksLeft() <= 1;
    }
}
