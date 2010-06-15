class AiStrategyPickMax implements IAiStrategy
{
    public Move
    chooseMove(Rules rules)
    {
        return new Move(rules.maxAllowedSticks());
    }
}
