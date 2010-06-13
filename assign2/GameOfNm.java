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
        //setPlayerOne(new PlayerComputer(ui, new AiStrategyPickAtRandom()));
        setPlayerTwo(new PlayerComputer(ui, new AiStrategyPickAtRandom()));
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

        playerOne.askForName("Player one");
        playerTwo.askForName("Player two");
    }

    protected void
    doTurn()
    {
        ui.display("There are " + pile.sticksLeft() + " sticks left.");
        applyMove(getPlayersMove(getNextPlayer()));
    }

    protected void
    endGame()
    {
        ui.display("The winner is " + currentPlayer.getName() + "!");

        currentPlayer.won();
        opponentTo(currentPlayer).lost();

        ui.display("The game is over.");
    }

    protected Boolean
    noWinner()
    {
        return pile.sticksLeft() > 1;
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
            currentPlayer = opponentTo(currentPlayer);
        }
        return currentPlayer;
    }

    protected IPlayer
    selectStartingPlayer()
    {
        return playerOne;
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
