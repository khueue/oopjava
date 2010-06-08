/**
 *
 */
class Nm
{
    protected IUserInterface ui = new UserInterfaceCommandLine();
    protected PileOfSticks pile = new PileOfSticks(20);
    protected Rules rules       = new Rules();

    public static void
    main(String[] args)
    {
        Nm game = new Nm();
        game.setUserInterface(new UserInterfaceCommandLine());
        game.setNumberOfSticks(10);
        game.setRules(new Rules());
        game.play();
    }

    public void
    setUserInterface(IUserInterface ui)
    throws IllegalArgumentException
    {
        if (ui == null)
        {
            throw new IllegalArgumentException("Must not be null!");
        }

        this.ui = ui;
    }

    public void
    setNumberOfSticks(Integer numberOfSticks)
    throws IllegalArgumentException
    {
        if (numberOfSticks == null)
        {
            throw new IllegalArgumentException("Must not be null!");
        }

        this.pile = new PileOfSticks(numberOfSticks);
    }

    public void
    setRules(Rules rules)
    throws IllegalArgumentException
    {
        if (rules == null)
        {
            throw new IllegalArgumentException("Must not be null!");
        }

        this.rules = rules;
    }

    public void
    play()
    {
        this.ui.sayWelcome();
    }
}
