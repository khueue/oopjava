class UserInterfaceCommandLine implements IUserInterface
{
    public void
    sayWelcome()
    {
        System.out.println("Game of Nm!");
    }

    public void
    sayGoodbye()
    {
        System.out.println("Come again!");
    }

    public void
    display(String msg)
    {
        System.out.println(msg);
    }
}
