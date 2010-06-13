class PlayerComputer extends Player
{
    protected IAiStrategy strategy;

    public
    PlayerComputer(IUserInterface ui, IAiStrategy strategy)
    {
        super(ui);

        Utils.throwIfNull(strategy);
        this.strategy = strategy;
    }

    protected String
    getDefaultName()
    {
        return "Computer";
    }

    public Move
    chooseMove(PileOfSticks pile, Rules rules)
    {
        return strategy.chooseMove(pile, rules);
    }
}
