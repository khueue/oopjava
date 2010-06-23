/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.util.Random;

public abstract class Util
{
    public static void
    throwIfNull(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Must not be null!");
        }
    }

    public static Integer
    randomIntegerBetween(Integer min, Integer max)
    {
        Random generator = new Random();
        Double zeroToAlmostOne = generator.nextDouble();
        return (int)(zeroToAlmostOne * (max-min+1)) + min;
    }
}
