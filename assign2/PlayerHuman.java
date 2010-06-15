class PlayerHuman extends Player
{
    protected static Integer id = 0; // To differentiate human players.

    public
    PlayerHuman(IUserInterface ui, Rules rules)
    {
        super(ui, rules);
    }

    protected String
    defaultName()
    {
        ++id;
        return "Human " + id;
    }

    public Move
    chooseMove()
    {
        Move move = readMove();
        while (!rules.isAllowedMove(move))
        {
            notifyIllegalMove(move);
            move = readMove();
        }
        return move;
    }

    protected Move
    readMove()
    {
        String prompt = name+", your move: ";
        Integer sticks = ui.promptForInteger(prompt);
        return new Move(sticks);
    }

    public void
    notifyIllegalMove(Move move)
    {
        Utils.throwIfNull(move);
        Integer min = rules.minAllowedSticks();
        Integer max = rules.maxAllowedSticks();
        ui.display("You must remove "+min+" to "+max+" sticks. Try again.");
    }

    public void
    won()
    {
        // Leave the reaction to the human being.
    }

    public void
    lost()
    {
        // Leave the reaction to the human being.
    }
}
