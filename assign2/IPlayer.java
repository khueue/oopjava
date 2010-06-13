interface IPlayer
{
    public Move
    chooseMove(Rules rules);

    public void
    notifyIllegalMove(Move move);

    public void
    askForName(String oldName);

    public void
    setName(String name);
    
    public String
    getName();

    public void
    won();

    public void
    lost();
}
