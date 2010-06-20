public abstract class Player implements IPlayer
{
    protected IUserInterface ui;
    protected Rules rules;
    protected PileOfSticks pile;
    protected String name;

    public
    Player(IUserInterface ui, Rules rules, PileOfSticks pile)
    {
        Util.throwIfNull(ui);
        this.ui = ui;

        Util.throwIfNull(rules);
        this.rules = rules;

        Util.throwIfNull(pile);
        this.pile = pile;

        this.name = defaultName();
    }

    abstract protected String
    defaultName();

    public String
    getName()
    {
        return name;
    }

    public void
    setName(String name)
    {
        Util.throwIfNull(name);
        this.name = name;
    }

    protected void
    applyMove(Move move)
    {
        pile.removeSticks(move.sticks());
        announceMove(move);
    }

    protected void
    announceMove(Move move)
    {
        if (move.sticks() == 1)
        {
            ui.display(name + " removes 1 stick.");
        }
        else
        {
            ui.display(name + " removes " + move.sticks() + " sticks.");
        }
    }
}
