import java.util.Random;

class Utils
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
        return (int)(generator.nextDouble() * (max-min+1)) + min;
    }
}
