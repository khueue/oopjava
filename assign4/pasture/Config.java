/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;

abstract public class Config
{
    static private Map<String,Integer> config = new HashMap<String,Integer>();

    static public Integer
    get(String name)
    {
        Integer value = config.get(name);
        if (value == null)
        {
            throw new RuntimeException("No such setting!");
        }
        return value;
    }

    static public void
    set(String name, Integer value)
    {
        config.put(name, value);
    }
}
