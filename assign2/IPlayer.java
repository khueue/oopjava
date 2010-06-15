interface IPlayer
{
    public Move
    chooseMove();

    public void
    notifyIllegalMove(Move move);

    public String
    getName();

    public void
    won();

    public void
    lost();
}
