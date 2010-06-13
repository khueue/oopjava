class UserInterfaceCommandLine implements IUserInterface
{
    public void
    onStart()
    {
        display("Welcome to a game of Nm!");
    }

    public void
    onClose()
    {
        display("The game is over!");
    }

    public void
    announceState(PileOfSticks pile)
    {
        if (pile.sticksLeft() == 1)
        {
            display("There is only one stick left!");
        }
        else
        {
            display("There are " + pile.sticksLeft() + " sticks left.");
        }
    }

    public void
    display(String msg)
    {
        System.out.println(msg);
    }
}
