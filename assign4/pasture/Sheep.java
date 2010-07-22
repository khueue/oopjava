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

    public
    Sheep(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/sheep.gif"));
        ticksUntilMove = TICKS_BETWEEN_MOVES;
    }

    public void
    tick()
    {
        move();
        eat();
        procreate();
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
            }

            ticksUntilMove = TICKS_BETWEEN_MOVES;
        }
    }

    public void
    eat()
    {
        List<Entity> victims = pasture.getFriends(this);
        for (Entity victim : victims)
        {
            if (victim instanceof Grass)
            {
                pasture.removeEntity(victim);
            }
        }
    }

    public void
    procreate()
    {
    }
}
