class GameOfNm
{
    protected IUserInterface ui;
    protected PileOfSticks pile;
    protected Rules rules;
    protected IPlayer playerOne;
    protected IPlayer playerTwo;
    protected IPlayer currentPlayer;

    public
    GameOfNm()
    {
        setUserInterface(new UserInterfaceCommandLine());
        setNumberOfSticks(20);
        setRules(new Rules(pile));
        setPlayerOne(new PlayerComputer(ui, new AiStrategyRandom()));
        setPlayerTwo(new PlayerComputer(ui, new AiStrategyRandom()));
    }

    public void
    setUserInterface(IUserInterface ui)
    {
        Utils.throwIfNull(ui);
        this.ui = ui;
    }

    public void
    setNumberOfSticks(Integer numberOfSticks)
    {
        Utils.throwIfNull(numberOfSticks);
        this.pile = new PileOfSticks(numberOfSticks);
    }

    public void
    setRules(Rules rules)
    {
        Utils.throwIfNull(rules);
        this.rules = rules;
    }

    public void
    setPlayerOne(IPlayer player)
    {
        Utils.throwIfNull(player);
        this.playerOne = player;
    }

    public void
    setPlayerTwo(IPlayer player)
    {
        Utils.throwIfNull(player);
        this.playerTwo = player;
    }

    public void
    play()
    {
        ui.onStart();

        IPlayer player = null;

        while (noWinner())
        {
            player = getNextPlayer();
            makeMove(getPlayersMove(player));
        }

        player.won();
        getOtherPlayer(player).lost();

        ui.onClose();
    }

    protected Boolean
    noWinner()
    {
        return pile.sticksLeft() > 1;
    }

    protected void
    makeMove(Move move)
    {
        pile.removeSticks(move.sticks());
    }

    protected IPlayer
    getNextPlayer()
    {
        if (currentPlayer == null)
        {
            currentPlayer = playerTwo;
        }
        currentPlayer = getOtherPlayer(currentPlayer);
        return currentPlayer;
    }

    protected IPlayer
    getOtherPlayer(IPlayer player)
    {
        return (player == playerOne) ? playerTwo : playerOne;
    }

    protected Move
    getPlayersMove(IPlayer player)
    {
        Move move = player.chooseMove(pile, rules);
        while (!rules.isAllowedMove(move))
        {
            player.notifyIllegalMove(move);
            move = player.chooseMove(pile, rules);
        }
        return move;
    }
}
