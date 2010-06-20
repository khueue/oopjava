/**
 * OOPJAVA - Assignment 2
 * Sebastian Lundström (selu7901)
 */

public abstract class Nm
{
    public static void
    main(String[] args)
    {
        if (args.length != 1)
        {
            printUsageAndExit();
        }

        Integer numSticks = convertToInt(args[0]);

        IUserInterface ui = new UserInterfaceCommandLine();
        PileOfSticks pile = new PileOfSticks(numSticks);
        Rules rules       = new Rules(pile);
        IPlayer playerOne = new PlayerHuman(ui, rules, pile);
        IPlayer playerTwo =
            new PlayerComputer(ui, rules, pile, new AiStrategyPickAtRandom());

        GameOfNm game = new GameOfNm(ui, pile, rules, playerOne, playerTwo);
        game.play();
    }

    protected static Integer
    convertToInt(String str)
    {
        Integer num = null;
        try
        {
            num = Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            printUsageAndExit();
        }
        return num;
    }

    protected static void
    printUsageAndExit()
    {
        System.err.println("Usage: java Nm <numSticks>");
        System.exit(0);
    }
}
