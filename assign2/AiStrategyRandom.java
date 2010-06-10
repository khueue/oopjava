class AiStrategyRandom implements IAiStrategy
{
    public Move
    chooseMove(PileOfSticks pile, Rules rules)
    {
        Move move = null;

        do
        {
            Integer rand = Utils.randomIntegerBetween(1, pile.half());
            move = new Move(rand);
        } while (!rules.isAllowedMove(move));

        return move;
    }
}
