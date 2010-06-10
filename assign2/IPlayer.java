interface IPlayer
{
    public Move
    selectMove(PileOfSticks pile, Rules rules);

    public void
    notifyIllegalMove(Move move);

    public void
    youWon();

    public void
    youLost();
}
