/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Sheep extends Entity
{
    public final Integer TICKS_BETWEEN_MOVES = 5;

    protected Integer ticksUntilMove;
    protected Integer ticksUntilReproduce;

    public
    Sheep(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/sheep.gif"));
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
            List<Point> freeAdjacent = pasture.getFreeAdjacentPositions(this);
            Point pos = Util.getRandomMember(freeAdjacent);
            if (pos != null)
            {
                pasture.moveEntity(this, pos);
                pasture.removeEntity(this);
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
            List<Point> freeAdjacent = pasture.getFreeAdjacentPositions(this);
            if (freeAdjacent.size() > 0)
            {
                Entity entity = new Sheep(pasture);
                Point pos = Util.getRandomMember(freeAdjacent);
                pasture.addEntity(entity, pos);
            }

            ticksUntilReproduce = (int)(1000 * Math.random()) + 100;
        }
    }
}
