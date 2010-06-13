class PlayerHuman extends Player
{
    protected static Integer id = 0; // To separate human players.

    public
    PlayerHuman(IUserInterface ui)
    {
        super(ui);
    }

    protected String
    defaultName()
    {
        Integer nextId = ++PlayerHuman.id;
        return "Human " + nextId;
    }

    public void
    askForName(String oldName)
    {
        Utils.throwIfNull(oldName);
        String name = ui.promptForString(oldName + ", enter your name: ");
        setName(name);
    }

    public Move
    chooseMove(Rules rules)
    {
        Utils.throwIfNull(rules);
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

    public void
    notifyIllegalMove(Move move)
    {
        Utils.throwIfNull(move);
        if (move.sticks() == 1)
        {
            ui.display("You may not remove 1 stick!");
        }
        else
        {
            ui.display("You may not remove " + move.sticks() + " sticks!");
        }
    }

    public void
    won()
    {
        // Leave the reaction up to the actual player.
    }

    public void
    lost()
    {
        // Leave the reaction up to the actual player.
    }
}
