import java.util.Random;

abstract class Utils
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
