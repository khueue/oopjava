import java.io.*;

class UserInterfaceCommandLine implements IUserInterface
{
    protected PrintStream out;
    protected PrintStream err;
    protected InputStream in;

    public
    UserInterfaceCommandLine()
    {
        out = System.out;
        err = System.err;
        in  = System.in;
    }

    public Integer
    promptForInt(String prompt)
    {
        for (;;)
        {
            try
            {
                String str = promptForString(prompt);
                return Integer.parseInt(str);
            }
            catch (NumberFormatException e)
            {
                display("You must choose an integer! Try again.");
            }
        }
    }

    public String
    promptForString(String prompt)
    {
        for (;;)
        {
            try
            {
                out.print(prompt);
                return readStringFromInput();
            }
            catch (IOException e)
            {
                display("Something went wrong with the input, exiting...");
                System.exit(0);
            }
        }
    }

    protected String
    readStringFromInput()
    throws IOException
    {
        Reader r = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(r);
        return br.readLine();
    }

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
        out.println(msg);
    }
}
