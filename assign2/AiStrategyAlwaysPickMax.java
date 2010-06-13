class AiStrategyAlwaysPickMax implements IAiStrategy
{
    public Move
    chooseMove(Rules rules)
    {
        return new Move(rules.maxAllowedSticks());
    }
}
