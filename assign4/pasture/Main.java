/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;

abstract public class Main
{
    static public void
    main(String[] args)
    {
        setupConfig(args);
        Pasture pasture = new Pasture();
        pasture.run();
    }

    static private void
    setupConfig(String[] args)
    {
        setupDefaults();
        handleInput(args);
    }

    static private void
    setupDefaults()
    {
        Config.add("sheep.initial.total",    20);
        Config.add("sheep.move.after",        4);
        Config.add("sheep.visibility",        3);
        Config.add("sheep.starve.after",    100);
        Config.add("sheep.reproduce.after", 101);

        Config.add("wolf.initial.total",     10);
        Config.add("wolf.move.after",         5);
        Config.add("wolf.visibility",         4);
        Config.add("wolf.starve.after",     200);
        Config.add("wolf.reproduce.after",  201);

        Config.add("grass.initial.total",    40);
        Config.add("grass.reproduce.after",  10);

        Config.add("fence.initial.total",    40);
    }

    static private void
    handleInput(String[] args)
    {
        if (args.length % 2 != 0)
        {
            printUsageAndExit();
        }

        Iterator<String> it = Arrays.asList(args).iterator();
        while (it.hasNext())
        {
            String key = it.next();
            Integer value = toInt(it.next());
            Config.update(key, value);
        }
    }

    static private void
    printUsageAndExit()
    {
        System.err.println("Usage: java pasture.Main [<key> <value>] ...");
        System.exit(0);
    }

    static private Integer
    toInt(String str)
    {
        Integer num = null;
        try
        {
            num = Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            printUsageAndExit();
        }
        return num;
    }
}
