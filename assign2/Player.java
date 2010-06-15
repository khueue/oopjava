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

    abstract protected String
    defaultName();

    public String
    getName()
    {
        return name;
    }
}
