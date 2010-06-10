class UserInterfaceCommandLine implements IUserInterface
{
    public void
    onStart()
    {
        System.out.println("Welcome to a game of Nm!");
    }

    public void
    onClose()
    {
        System.out.println("The game is over!");
    }

    public void
    display(String msg)
    {
        System.out.println(msg);
    }
}
