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
    private Integer ticksUntilReproduce = (int)(1000 * Math.random()) + 100;

    public
    Grass(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/plant.gif"));
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

    private void
    move()
    {
    }

    private void
    eat()
    {
    }

    private void
    reproduce()
    {
        if (--ticksUntilReproduce == 0)
        {
            List<Point> freeAdjacent = pasture.getNearestFreePositions(this, 1);
            if (freeAdjacent.size() > 0)
            {
                Entity entity = new Grass(pasture);
                Point pos = Util.getRandomMember(freeAdjacent);
                pasture.addEntity(entity, pos);
            }

            ticksUntilReproduce = (int)(100 * Math.random()) + 100;
        }
    }
}
