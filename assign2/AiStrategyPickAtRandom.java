public class AiStrategyPickAtRandom implements IAiStrategy
{
    public Move
    chooseMove(Rules rules)
    {
        Integer min = rules.minAllowedSticks();
        Integer max = rules.maxAllowedSticks();
        Integer sticks = Util.randomIntegerBetween(min, max);
        return new Move(sticks);
    }
}
