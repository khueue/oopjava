class AiStrategyPickAtRandom implements IAiStrategy
{
    public Move
    chooseMove(PileOfSticks pile, Rules rules)
    {
        Move move = createRandomMove(pile);
        while (!rules.isAllowedMove(move));
        {
            move = createRandomMove(pile);
        }
        return move;
    }

    protected Move
    createRandomMove(PileOfSticks pile)
    {
        Integer rand = Utils.randomIntegerBetween(1, pile.half());
        return new Move(rand);
    }
}
