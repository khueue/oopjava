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
        this.setUserInterface(new UserInterfaceCommandLine());
        this.setNumberOfSticks(20);
        this.setRules(new Rules(this.pile));
        this.setPlayerOne(new PlayerComputer(this.ui));
        this.setPlayerTwo(new PlayerComputer(this.ui));
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
        this.ui.sayWelcome();

        IPlayer player = null;

        while (this.noWinner())
        {
            player = this.getNextPlayer();
            this.makeMove(this.getPlayersMove(player));
        }

        player.youWon();
        this.getOtherPlayer(player).youLost();

        this.ui.sayGoodbye();
    }

    protected Boolean
    noWinner()
    {
        return this.pile.sticksLeft() > 1;
    }

    protected void
    makeMove(Move move)
    {
        this.pile.removeSticks(move.sticks());
    }

    protected IPlayer
    getNextPlayer()
    {
        if (this.currentPlayer == null)
        {
            this.currentPlayer = this.playerTwo;
        }
        this.currentPlayer = this.getOtherPlayer(this.currentPlayer);
        return this.currentPlayer;
    }

    protected IPlayer
    getOtherPlayer(IPlayer player)
    {
        return (player == this.playerOne) ? this.playerTwo : this.playerOne;
    }

    protected Move
    getPlayersMove(IPlayer player)
    {
        Move move = player.selectMove(this.pile, this.rules);
        while (!this.rules.isAllowedMove(move))
        {
            player.notifyIllegalMove(move);
            move = player.selectMove(this.pile, this.rules);
        }
        return move;
    }
}
