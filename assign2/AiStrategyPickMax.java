/**
 * OOPJAVA - Assignment 2
 * Sebastian Lundström (selu7901)
 */

public class AiStrategyPickMax implements IAiStrategy
{
    public Move
    chooseMove(Rules rules)
    {
        return new Move(rules.maxAllowedSticks());
    }
}
