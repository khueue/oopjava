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
        ui.display("OMG!");
    }

    public void
    won()
    {
        ui.display("Weee, I won!");
    }

    public void
    lost()
    {
        ui.display("Dang, I lost!");
    }
}
