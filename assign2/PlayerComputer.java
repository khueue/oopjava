class PlayerComputer extends Player
{
    protected static Integer id = 0; // To differentiate computer players.

    protected IAiStrategy strategy;

    public
    PlayerComputer(IUserInterface ui, Rules rules, IAiStrategy strategy)
    {
        super(ui, rules);

        Utils.throwIfNull(strategy);
        this.strategy = strategy;
    }

    protected String
    defaultName()
    {
        ++id;
        return "Computer " + id;
    }

    public Move
    chooseMove()
    {
        ui.display(name+", your move. ");
        return strategy.chooseMove(rules);
    }

    public void
    notifyIllegalMove(Move move)
    {
    }

    public void
    won()
    {
        ui.display(name+": Yes, I won!");
    }

    public void
    lost()
    {
        ui.display(name+": Nooo, I lost!");
    }
}
