abstract class Player implements IPlayer
{
    protected IUserInterface ui;

    public
    Player(IUserInterface ui)
    {
        Utils.throwIfNull(ui);
        this.ui = ui;
    }

    public void
    notifyIllegalMove(Move move)
    {
        this.ui.announce("OMG!");
    }

    /* ccccccxxxxxxxx remove */
    public Move
    selectMove(PileOfSticks pile, Rules rules)
    {
        Integer rand = Utils.randomIntegerBetween(1, 5);
        return new Move(rand);
    }

    public void
    youWon()
    {
        ui.announce("Weee, I won!");
    }

    public void
    youLost()
    {
        ui.announce("Dang, I lost!");
    }
}
