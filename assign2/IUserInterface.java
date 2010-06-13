interface IUserInterface
{
    public void
    onStart();

    public void
    onClose();

    public String
    promptForString(String prompt);

    public Integer
    promptForInt(String prompt);

    public void
    announceState(PileOfSticks pile);

    public void
    display(String msg);
}
