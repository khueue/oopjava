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
    public final Integer TICKS_BETWEEN_MOVES = 5;

    protected Integer ticksUntilMove;
    protected Integer ticksUntilReproduce;

    public
    Sheep(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/sheep.gif"));
        ticksUntilMove = TICKS_BETWEEN_MOVES;
        ticksUntilReproduce = 30;
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
            List<Point> safe = pasture.getNearestSafePositions(this, 1);
            Point pos = Util.getRandomMember(safe);
            if (pos != null)
            {
                pasture.moveEntity(this, pos);
            }

            ticksUntilMove = TICKS_BETWEEN_MOVES;
        }
    }

    public void
    eat()
    {
        List<Entity> victims = pasture.getOtherEntitiesAtSamePosition(this);
        for (Entity victim : victims)
        {
            if (victim instanceof Grass)
            {
                pasture.removeEntity(victim);
            }
        }
    }

    public void
    reproduce()
    {
        if (--ticksUntilReproduce == 0)
        {
            ticksUntilReproduce = Util.randomIntegerBetween(50, 150);

            List<Point> safe = pasture.getNearestSafePositions(this, 1);
            if (safe.size() > 0)
            {
                Entity entity = new Sheep(pasture);
                Point pos = Util.getRandomMember(safe);
                pasture.addEntity(entity, pos);
            }
        }
    }
}
