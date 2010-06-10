interface IPlayer
{
    public Move
    chooseMove(PileOfSticks pile, Rules rules);

    public void
    notifyIllegalMove(Move move);

    public void
    won();

    public void
    lost();
}
