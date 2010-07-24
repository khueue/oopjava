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
    public final Integer TICKS_BETWEEN_MOVES = 5;

    protected Integer ticksUntilMove;
    protected Integer ticksUntilReproduce;

    public
    Wolf(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/wolf.gif"));
        ticksUntilMove = TICKS_BETWEEN_MOVES;
        ticksUntilReproduce = (int)(1000 * Math.random()) + 100;
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
    maySharePositionWith(Entity entity)
    {
        return !(entity instanceof Fence);
    }

    public void
    move()
    {
        if (--ticksUntilMove == 0)
        {
            ticksUntilMove = TICKS_BETWEEN_MOVES;

            List<Point> safe = pasture.getNearestSafePositions(this, 1);
            Point pos = Util.getRandomMember(safe);
            if (pos != null)
            {
                pasture.moveEntity(this, pos);
            }
        }
    }

    public void
    eat()
    {
        List<Entity> victims = pasture.getOtherEntitiesAtSamePosition(this);
        for (Entity victim : victims)
        {
            if (victim instanceof Sheep)
            {
                pasture.removeEntity(victim);
            }
        }
    }
}
