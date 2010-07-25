/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;

abstract public class MobileEntity extends Entity
{
    protected Integer ticksUntilMove;

    public
    MobileEntity(Pasture pasture, ImageIcon image)
    {
        super(pasture, image);
    }

    public void
    tick()
    {
        if (notRemoved())
        {
            move();
            eat();
            reproduce();
        }
    }

    public void
    move()
    {
        if (--ticksUntilMove == 0)
        {
            ticksUntilMove = 10;

            List<Point> safe = pasture.getNearestSafePositions(this, 1);
            if (safe.size() > 0)
            {
                Point pos = Util.getRandomMember(safe);
                pasture.moveEntity(this, pos);
            }
        }
    }
}
