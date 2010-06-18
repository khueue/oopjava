public class AiStrategyPickMin implements IAiStrategy
{
    public Move
    chooseMove(Rules rules)
    {
        return new Move(rules.minAllowedSticks());
    }
}
