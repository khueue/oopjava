class UserInterfaceCommandLine implements IUserInterface
{
    public void
    onStart()
    {
        puts("Welcome to a game of Nm!");
    }

    public void
    onClose()
    {
        puts("The game is over!");
    }

    public void
    display(String msg)
    {
        puts(msg);
    }

    protected void
    puts(String str)
    {
        System.out.println(str);
    }
}
