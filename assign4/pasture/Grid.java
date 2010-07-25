/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;

public class Grid
{
    // Each position can have several occupants.
    private final Map<Point, List<Entity>> grid =
        new HashMap<Point, List<Entity>>();

    private Integer width;
    private Integer height;

    public
    Grid(Integer width, Integer height)
    {
        this.width  = width;
        this.height = height;
    }

    /**
     * This method ensures that we never have to deal with null: the list is
     * either empty or non-empty, but never null.
     */
    public List<Entity>
    getOccupants(Point pos)
    {
        List<Entity> occupants = grid.get(pos);
        if (occupants == null)
        {
            occupants = new ArrayList<Entity>();
            grid.put(pos, occupants);
        }
        return occupants;
    }

    public Boolean
    addOccupant(Point pos, Entity entity)
    {
        return getOccupants(pos).add(entity);
    }

    public Boolean
    removeOccupant(Point pos, Entity entity)
    {
        return getOccupants(pos).remove(entity);
    }

    public Point
    getRandomSafePosition(Entity entity)
    {
        Point pos = new Point(
            (int)(Math.random() * width),
            (int)(Math.random() * height));

        int p = pos.x + (pos.y * width);
        int m = height * width;
        int q = 97; // Any large prime will do.

        for (int i = 0; i < m; ++i)
        {
            int j = (p + i*q) % m;
            int x = j % width;
            int y = j / width;

            pos = new Point(x, y);
            if (entity.mayStandAt(pos))
            {
                return pos;
            }
        }

        throw new MissingResourceException(
            "There is no safe space left in the pasture for this entity!",
            "Pasture",
            "");
    }

    public List<Point>
    getNearestPositions(Point origin, Integer radius)
    {
        List<Point> nearest = new ArrayList<Point>();
        for (int x = -radius; x <= radius; ++x)
        {
            for (int y = -radius; y <= radius; ++y)
            {
                Point pos = new Point(origin.x + x, origin.y + y);
                nearest.add(pos);
            }
        }
        return nearest;
    }

    public List<Point>
    getNearestSafePositions(Entity entity, Integer radius)
    {
        Point pos = entity.getPosition();
        List<Point> nearest = getNearestPositions(pos, radius);
        return excludeNonSafePositions(nearest, entity);
    }

    private List<Point>
    excludeNonSafePositions(List<Point> positions, Entity entity)
    {
        Iterator<Point> it = positions.iterator();
        while (it.hasNext())
        {
            Point pos = it.next();
            if (!entity.mayStandAt(pos))
            {
                it.remove();
            }
        }
        return positions;
    }

    public List<Entity>
    getOtherEntitiesAtSamePosition(Entity entity)
    {
        List<Entity> others = new ArrayList<Entity>();
        for (Entity occupant : getOccupants(entity.getPosition()))
        {
            if (occupant != entity)
            {
                others.add(occupant);
            }
        }
        return others;
    }

    public Boolean
    isSafePosition(Point pos, Entity entity)
    {
        for (Entity occupant : getOccupants(pos))
        {
            if (!entity.maySharePositionWith(occupant))
            {
                return false;
            }
        }
        return true;
    }
}
