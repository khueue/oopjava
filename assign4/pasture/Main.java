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
        Config.set("sheep.initial.total",    10);
        Config.set("sheep.move.after",        5);
        Config.set("sheep.visibility",        3);
        Config.set("sheep.starve.after",    100);
        Config.set("sheep.reproduce.after", 101);

        Config.set("wolf.initial.total",     20);
        Config.set("wolf.move.after",         4);
        Config.set("wolf.visibility",         3);
        Config.set("wolf.starve.after",     200);
        Config.set("wolf.reproduce.after",  201);

        Config.set("grass.initial.total",    40);
        Config.set("grass.reproduce.after",  50);

        Config.set("fence.initial.total",    40);
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
            String key    = it.next();
            Integer value = toInt(it.next());
            Config.set(key, value);
        }
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

    static private void
    printUsageAndExit()
    {
        System.err.println("Usage: java pasture.Main [<key> <value>] ...");
        System.exit(0);
    }
}
