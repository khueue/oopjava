class PlayerHuman extends Player
{
    public
    PlayerHuman(IUserInterface ui)
    {
        super(ui);
    }

    protected String
    getDefaultName()
    {
        return "Human";
    }

    public void
    introduce()
    {
        String name = ui.promptForString("Your name, please: ");
        setName(name);
    }

    public Move
    chooseMove(PileOfSticks pile, Rules rules)
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
        String prompt = name + ", choose number of sticks: ";
        Integer sticks = ui.promptForInteger(prompt);
        return new Move(sticks);
    }
}
