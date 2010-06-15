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
        setPlayerOne(new PlayerHuman(ui, rules));
        //setPlayerOne(new PlayerComputer(ui, rules, new AiStrategyPickAtRandom()));
        setPlayerTwo(new PlayerComputer(ui, rules, new AiStrategyPickAtRandom()));
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
        startGame();
        while (noWinner())
        {
            doTurn();
        }
        endGame();
    }

    protected void
    startGame()
    {
        ui.display("Welcome to a game of Nm!");

        pickStartingPlayer();
    }

    protected void
    doTurn()
    {
        announceGameState();

        IPlayer player = getNextPlayer();
        Move move = getPlayersMove(player);
        applyMove(move);

        announceMoveMade(player, move);
    }

    protected void
    announceGameState()
    {
        ui.display("--- Remaining sticks: " + pile.sticksLeft());
    }

    protected void
    announceMoveMade(IPlayer player, Move move)
    {
        String str = null;
        if (move.sticks() == 1)
        {
            str = player.getName() + " removes 1 stick.";
        }
        else
        {
            str = player.getName() + " removes " + move.sticks() + " sticks.";
        }
        ui.display(str);
    }

    protected void
    endGame()
    {
        ui.display("The winner is ... " + currentPlayer.getName() + "!");

        currentPlayer.won();
        opponentTo(currentPlayer).lost();
    }

    protected Boolean
    noWinner()
    {
        return pile.sticksLeft() > 1;
    }

    protected void
    pickStartingPlayer()
    {
        ui.display("Picking starting player at random ...");
        int rand = Utils.randomIntegerBetween(1, 2);
        for (int i = 0; i < rand; ++i)
        {
            getNextPlayer();
        }
    }

    protected IPlayer
    getNextPlayer()
    {
        return currentPlayer = opponentTo(currentPlayer);
    }

    protected IPlayer
    opponentTo(IPlayer player)
    {
        return (player == playerOne) ? playerTwo : playerOne;
    }

    protected Move
    getPlayersMove(IPlayer player)
    {
        Move move = player.chooseMove(rules);
        while (!rules.isAllowedMove(move))
        {
            player.notifyIllegalMove(move);
            announceGameState();
            move = player.chooseMove(rules);
        }
        return move;
    }

    protected void
    applyMove(Move move)
    {
        pile.removeSticks(move.sticks());
    }
}
