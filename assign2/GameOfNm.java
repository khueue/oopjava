/**
 *
 */
class GameOfNm
{
    protected IUserInterface ui = new UserInterfaceCommandLine();
    protected PileOfSticks pile = new PileOfSticks(20);
    protected Rules rules       = new Rules();

    public void
    setUserInterface(IUserInterface ui)
    {
        if (ui == null)
        {
            throw new IllegalArgumentException("Must not be null!");
        }
        this.ui = ui;
    }

    public void
    setNumberOfSticks(Integer numberOfSticks)
    {
        if (numberOfSticks == null)
        {
            throw new IllegalArgumentException("Must not be null!");
        }
        this.pile = new PileOfSticks(numberOfSticks);
    }

    public void
    setRules(Rules rules)
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
