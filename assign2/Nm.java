class Nm
{
    public static void
    main(String[] args)
    {
        if (args.length != 1)
        {
            Nm.printUsageAndExit();
        }

        IUserInterface ui = new UserInterfaceCommandLine();
        PileOfSticks pile = new PileOfSticks(Integer.parseInt(args[0]));
        Rules rules       = new Rules(pile);
        IPlayer playerOne = new PlayerHuman(ui, rules);
        IPlayer playerTwo = new PlayerComputer(
            ui, rules, new AiStrategyPickAtRandom());

        GameOfNm game = new GameOfNm(ui, pile, rules, playerOne, playerTwo);
        game.play();
    }

    public static void
    printUsageAndExit()
    {
        System.err.println("Usage: java Nm <numSticks>");
        System.exit(0);
    }
}
