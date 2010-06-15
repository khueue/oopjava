class PlayerHuman extends Player
{
    protected static Integer id = 0; // To differentiate human players.

    public
    PlayerHuman(IUserInterface ui, Rules rules, PileOfSticks pile)
    {
        super(ui, rules, pile);
    }

    protected String
    defaultName()
    {
        ++id;
        return "Human " + id;
    }

    public void
    takeTurn()
    {
        Move move = readMove();
        while (rules.isIllegalMove(move))
        {
            moveIsIllegal(move);
            move = readMove();
        }
        applyMove(move);
    }

    protected Move
    readMove()
    {
        String prompt = name + ", your move: ";
        Integer sticks = ui.promptForInteger(prompt);
        return new Move(sticks);
    }

    protected void
    moveIsIllegal(Move move)
    {
        Integer min = rules.minAllowedSticks();
        Integer max = rules.maxAllowedSticks();
        ui.display(
            "You must remove " + min + " to " + max + " sticks. Try again.");
    }

    public void
    won()
    {
        // Leave the reaction to the actual human being.
    }

    public void
    lost()
    {
        // Leave the reaction to the actual human being.
    }
}
