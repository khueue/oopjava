abstract class Player implements IPlayer
{
    protected IUserInterface ui;
    protected Rules rules;
    protected String name;

    public
    Player(IUserInterface ui, Rules rules)
    {
        Utils.throwIfNull(ui);
        this.ui = ui;

        Utils.throwIfNull(rules);
        this.rules = rules;

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
