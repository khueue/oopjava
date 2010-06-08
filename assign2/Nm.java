/**
 *
 */
class Nm
{
    public static void
    main(String[] args)
    {
        if (args.length != 1)
        {
            Nm.printUsageAndExit();
        }

        GameOfNm game = new GameOfNm();
        game.setUserInterface(new UserInterfaceCommandLine());
        game.setNumberOfSticks(Integer.parseInt(args[0]));
        game.setRules(new Rules());
        game.play();
    }

    public static void
    printUsageAndExit()
    {
        System.err.println("Usage: java Nm <numberOfSticks>");
        System.exit(0);
    }
}
