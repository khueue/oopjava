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
        setPlayerOne(new PlayerHuman(ui));
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
        ui.display("Welcome to a game of Nm!");

        playerOne.introduce();
        playerTwo.introduce();

        IPlayer player = null;

        while (noWinner())
        {
            announceState();
            player = getNextPlayer();
            applyMove(getPlayersMove(player));
        }

        player.won();
        getOpponentTo(player).lost();

        ui.display("The game is over!");
    }

    protected Boolean
    noWinner()
    {
        return pile.sticksLeft() > 1;
    }

    protected void
    announceState()
    {
        if (pile.sticksLeft() == 1)
        {
            ui.display("There is only one stick left!");
        }
        else
        {
            ui.display("There are " + pile.sticksLeft() + " sticks left.");
        }
    }

    protected void
    applyMove(Move move)
    {
        pile.removeSticks(move.sticks());
    }

    protected IPlayer
    getNextPlayer()
    {
        if (currentPlayer == null)
        {
            currentPlayer = selectStartingPlayer();
        }
        else
        {
            currentPlayer = getOpponentTo(currentPlayer);
        }
        return currentPlayer;
    }

    protected IPlayer
    selectStartingPlayer()
    {
        return playerOne;
    }

    protected IPlayer
    getOpponentTo(IPlayer player)
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
