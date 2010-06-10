class PlayerHuman extends Player
{
    public
    PlayerHuman(IUserInterface ui)
    {
        super(ui);
    }
    
    // xxxxxxxxxxxxx
    public Move
    chooseMove(PileOfSticks pile, Rules rules)
    {
        return new Move(1);
    }
}
