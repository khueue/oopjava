abstract class Player implements IPlayer
{
    protected IUserInterface ui;
    protected String name;

    public
    Player(IUserInterface ui)
    {
        Utils.throwIfNull(ui);
        this.ui = ui;
        this.name = getDefaultName();
    }

    protected String
    getDefaultName()
    {
        return "[anonymous]";
    }

    public void
    setName(String name)
    {
        Utils.throwIfNull(name);
        this.name = name;
    }

    public void
    notifyIllegalMove(Move move)
    {
        if (move.sticks() == 1)
        {
            ui.display("You may not remove 1 stick!");
        }
        else
        {
            ui.display("You may not remove " + move.sticks() + " sticks!");
        }
    }

    public void
    won()
    {
        ui.display(name + ": Weee, I won!");
    }

    public void
    lost()
    {
        ui.display(name + ": Dang, I lost!");
    }
}
