class Rules
{
    protected PileOfSticks pile;

    public
    Rules(PileOfSticks pile)
    {
        Utils.throwIfNull(pile);
        this.pile = pile;
    }

    public Boolean
    isAllowedMove(Move move)
    {
        Utils.throwIfNull(move);
        Boolean atLeast = move.sticks() >= minAllowedSticks();
        Boolean atMost  = move.sticks() <= maxAllowedSticks();
        return atLeast && atMost;
    }
    
    public Integer
    minAllowedSticks()
    {
        return 1;
    }
    
    public Integer
    maxAllowedSticks()
    {
        return pile.half();
    }
}
