abstract class Player implements IPlayer
{
    protected IUserInterface ui;
    protected String name;

    public
    Player(IUserInterface ui)
    {
        Utils.throwIfNull(ui);
        this.ui = ui;
        this.name = defaultName();
    }

    protected String
    defaultName()
    {
        return "[anonymous]";
    }

    public String
    getName()
    {
        return name;
    }

    public void
    setName(String name)
    {
        Utils.throwIfNull(name);
        this.name = name;
    }
}
