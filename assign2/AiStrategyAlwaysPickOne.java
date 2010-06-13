class AiStrategyAlwaysPickOne implements IAiStrategy
{
    public Move
    chooseMove(PileOfSticks pile, Rules rules)
    {
        return new Move(1);
    }
}
