/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Wolf extends MobileEntity
{
    public
    Wolf(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/wolf.gif"));
        ticksUntilMove = Util.randomIntegerBetween(5, 15);
        ticksUntilReproduce = Util.randomIntegerBetween(30, 150);
    }

    public Boolean
    isCarnivore()
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
