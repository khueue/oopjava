class GameOfNm
{
    protected IUserInterface ui;
    protected PileOfSticks pile;
    protected Rules rules;
    protected IPlayer playerOne;
    protected IPlayer playerTwo;
    protected IPlayer currentPlayer;

    public
    GameOfNm(
        IUserInterface ui,
        PileOfSticks pile,
        Rules rules,
        IPlayer playerOne,
        IPlayer playerTwo)
    {
        Utils.throwIfNull(ui);
        this.ui = ui;

        Utils.throwIfNull(pile);
        this.pile = pile;

        Utils.throwIfNull(rules);
        this.rules = rules;

        Utils.throwIfNull(playerOne);
        this.playerOne = playerOne;

        Utils.throwIfNull(playerTwo);
        this.playerTwo = playerTwo;
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
        player.takeTurn();
    }

    protected void
    announceGameState()
    {
        ui.display("--- Remaining sticks: " + pile.sticksLeft() + " ---");
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
}
