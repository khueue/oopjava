abstract class Player implements IPlayer
{
    protected IUserInterface ui;
    protected Rules rules;
    protected PileOfSticks pile;
    protected String name;

    public
    Player(IUserInterface ui, Rules rules, PileOfSticks pile)
    {
        Utils.throwIfNull(ui);
        this.ui = ui;

        Utils.throwIfNull(rules);
        this.rules = rules;

        Utils.throwIfNull(pile);
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
        Utils.throwIfNull(name);
        this.name = name;
    }

    protected void
    applyMove(Move move)
    {
        pile.removeSticks(move.sticks());
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
