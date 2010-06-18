public class PlayerComputer extends Player
{
    protected static Integer id = 0; // To differentiate computer players.

    protected IAiStrategy strategy;

    public
    PlayerComputer(
        IUserInterface ui,
        Rules rules,
        PileOfSticks pile,
        IAiStrategy strategy)
    {
        super(ui, rules, pile);

        Utils.throwIfNull(strategy);
        this.strategy = strategy;
    }

    protected String
    defaultName()
    {
        ++id;
        return "Computer " + id;
    }

    public void
    takeTurn()
    {
        ui.display(name + ", your move.");

        Move move = strategy.chooseMove(rules);
        applyMove(move);
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
