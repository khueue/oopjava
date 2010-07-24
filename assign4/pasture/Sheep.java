/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Sheep extends MobileEntity
{
    public
    Sheep(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/sheep.gif"));
        ticksUntilMove = Util.randomIntegerBetween(5, 15);
        ticksUntilReproduce = Util.randomIntegerBetween(30, 70);
    }

    public void
    tick()
    {
        if (!isRemoved())
        {
            move();
            eat();
            reproduce();
        }
    }

    public Boolean
    isHerbivore()
    {
        return true;
    }

    public Boolean
    isAnimal()
    {
        return true;
    }

    public Boolean
    maySharePositionWith(Entity entity)
    {
        return !(entity instanceof Fence);
    }
}
