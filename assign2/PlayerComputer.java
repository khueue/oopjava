class PlayerComputer extends Player
{
    protected static Integer id = 0; // To separate computer players.

    protected IAiStrategy strategy;

    public
    PlayerComputer(IUserInterface ui, IAiStrategy strategy)
    {
        super(ui);

        Utils.throwIfNull(strategy);
        this.strategy = strategy;
    }

    protected String
    defaultName()
    {
        Integer nextId = ++PlayerComputer.id;
        return "Computer " + nextId;
    }

    public void
    askForName(String oldName)
    {
    }

    public Move
    chooseMove(Rules rules)
    {
        return strategy.chooseMove(rules);
    }

    public void
    notifyIllegalMove(Move move)
    {
    }

    public void
    won()
    {
        ui.display(name + ": Yes, I won!");
    }

    public void
    lost()
    {
        ui.display(name + ": Nooo, I lost!");
    }
}
