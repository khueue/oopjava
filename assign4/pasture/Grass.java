/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Grass extends Plant
{
    public
    Grass(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/plant.gif"));
        ticksUntilReproduce = Util.randomIntegerBetween(60, 90);
    }

    public void
    tick()
    {
        if (notRemoved())
        {
            reproduce();
        }
    }

    public Boolean
    isVegetable()
    {
        return true;
    }
}
