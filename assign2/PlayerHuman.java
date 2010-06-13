import java.io.*;

class PlayerHuman extends Player
{
    public
    PlayerHuman(IUserInterface ui)
    {
        super(ui);
    }

    protected String
    getDefaultName()
    {
        return "Human";
    }

    public Move
    chooseMove(PileOfSticks pile, Rules rules)
    {
        Reader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        ui.display("Human, choose number of sticks: ");
        for (;;)
        {
            try
            {
                String line = br.readLine();
                Integer sticks = Integer.parseInt(line);
                return new Move(sticks);
            }
            catch (IOException e)
            {
                ui.display("Something went wrong with the input, exiting...");
                System.exit(0);
            }
            catch (NumberFormatException e)
            {
                ui.display("Must be an integer! Try again.");
            }
        }
    }
}
