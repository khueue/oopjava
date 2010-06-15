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
        announceStartOfGame();
        pickStartingPlayerRandomly();
    }

    protected void
    doTurn()
    {
        announceGameState();

        IPlayer player = getNextPlayer();
        player.takeTurn();
    }

    protected void
    endGame()
    {
        announceEndOfGame();
        currentPlayer.won();
        opponentTo(currentPlayer).lost();
    }

    protected Boolean
    noWinner()
    {
        return pile.sticksLeft() > 1;
    }

    protected void
    pickStartingPlayerRandomly()
    {
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

    protected void
    announceStartOfGame()
    {
        ui.display("Welcome to a game of Nm!");
    }

    protected void
    announceEndOfGame()
    {
        ui.display("The winner is ... " + currentPlayer.getName() + "!");
    }

    protected void
    announceGameState()
    {
        ui.display("--- Remaining sticks: " + pile.sticksLeft() + " ---");
    }
}
