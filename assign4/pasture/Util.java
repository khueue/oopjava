/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;

abstract public class Util
{
    static public void
    throwIfNull(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Must not be null!");
        }
    }

    static public Integer
    randomIntegerBetween(Integer min, Integer max)
    {
        Random generator = new Random();
        Double zeroToAlmostOne = generator.nextDouble();
        return (int)(zeroToAlmostOne * (max-min+1)) + min;
    }

    static public <T> T
    getRandomMember(List<T> list)
    {
        int rand = (int)(Math.random() * list.size());
        return list.get(rand);
    }

    static public List<Point>
    intersection(List<Point> a, List<Point> b)
    {
        List<Point> result = new ArrayList<Point>();
        for (Point pos : a)
        {
            if (in(b, pos))
            {
                result.add(pos);
            }
        }
        return result;
    }

    static private Boolean
    in(List<Point> list, Point pos)
    {
        for (Point p : list)
        {
            if (pos.equals(p))
            {
                return true;
            }
        }
        return false;
    }
}
