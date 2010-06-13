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
        Utils.throwIfNull(min);
        Utils.throwIfNull(max);
        Random generator = new Random();
        return (int)(generator.nextDouble() * (max-min+1)) + min;
    }
}
