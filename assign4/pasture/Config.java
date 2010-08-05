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
        mustExist(key);
        return config.get(key);
    }

    static public void
    set(String key, Integer value)
    {
        config.put(key, value);
    }

    static public void
    add(String key, Integer value)
    {
        mustNotExist(key);
        set(key, value);
    }

    static public void
    update(String key, Integer value)
    {
        mustExist(key);
        set(key, value);
    }

    static private void
    mustExist(String key)
    {
        if (!config.containsKey(key))
        {
            throw new RuntimeException("Setting does not exist: " + key);
        }
    }

    static private void
    mustNotExist(String key)
    {
        if (config.containsKey(key))
        {
            throw new RuntimeException("Setting already exists: " + key);
        }
    }
}
