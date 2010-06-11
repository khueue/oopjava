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
        return 1 <= move.sticks() && move.sticks() <= pile.half();
    }
}
