/**
 *
 */
class Nm
{
    protected Rules rules = null;
    protected PileOfSticks pile = null;
    protected IUserInterface ui = null;

    public
    Nm(IUserInterface ui)
    {
        this.ui    = ui;
        this.rules = new Rules();
        this.pile  = new PileOfSticks();
    }

    public void
    run()
    {
        System.out.println("Game of Nm!");
    }

    public static void
    main(String[] args)
    {
        Nm game = new Nm(new UserInterfaceCommandLine());
        game.run();
    }
}
