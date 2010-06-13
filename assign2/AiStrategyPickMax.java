class AiStrategyPickMax implements IAiStrategy
{
    public Move
    chooseMove(Rules rules)
    {
        Utils.throwIfNull(rules);
        return new Move(rules.maxAllowedSticks());
    }
}
