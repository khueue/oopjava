import java.io.*;

class UserInterfaceCommandLine implements IUserInterface
{
    protected PrintStream out;
    protected InputStream in;

    public
    UserInterfaceCommandLine()
    {
        out = System.out;
        in  = System.in;
    }

    public void
    display(String msg)
    {
        Utils.throwIfNull(msg);
        out.println(msg);
    }

    public Integer
    promptForInteger(String prompt)
    {
        Utils.throwIfNull(prompt);
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
        Utils.throwIfNull(prompt);
        for (;;)
        {
            try
            {
                out.print(prompt);
                return readStringFromConsole();
            }
            catch (IOException e)
            {
                display("Something went wrong with the input, exiting...");
                System.exit(0);
            }
        }
    }

    protected String
    readStringFromConsole()
    throws IOException
    {
        Reader r = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(r);
        return br.readLine();
    }
}
