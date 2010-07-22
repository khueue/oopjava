/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;

public class Grid
{
    private final Map<Point, List<Entity>> grid =
        new HashMap<Point, List<Entity>>();

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
}
