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
        Double zeroToOne = generator.nextDouble();
        return (int)(zeroToOne * (max-min+1)) + min;
    }
}
