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
        game.play();
    }

    public static void
    printUsageAndExit()
    {
        System.err.println("Usage: java Nm <numberOfSticks>");
        System.exit(0);
    }
}
