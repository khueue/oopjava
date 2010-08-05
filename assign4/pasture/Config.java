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
    get(String key)
    {
        Integer value = config.get(key);
        if (value == null)
        {
            throw new RuntimeException("No such setting: " + key);
        }
        return value;
    }

    static public void
    set(String key, Integer value)
    {
        config.put(key, value);
    }

    static public void
    add(String key, Integer value)
    {
        if (config.get(key) != null)
        {
            throw new RuntimeException("Setting already exists: " + key);
        }
        config.put(key, value);
    }

    static public void
    update(String key, Integer value)
    {
        if (config.get(key) == null)
        {
            throw new RuntimeException("Setting does not exist: " + key);
        }
        config.put(key, value);
    }
}
