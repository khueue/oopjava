/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;

/**
 * A pasture contains sheep, wolves, fences, plants, and possibly
 * other entities. These entities move around in the pasture and try
 * to find food, other entities of the same kind and run away from
 * possible enimies.
 */
public class Pasture
{
    private final int width = 20;
    private final int height = 20;

    private final int numSheep = 20;

    private final Set<Entity> entities = new HashSet<Entity>();
    private final Map<Point, List<Entity>> grid = new HashMap<Point, List<Entity>>();
    private final Map<Entity, Point> points = new HashMap<Entity, Point>();

    private final PastureGUI gui;

    public
    Pasture()
    {
        Engine engine = new Engine(this);
        gui = new PastureGUI(width, height, engine);

        createFence();
        createSheep();
    }

    protected void
    createFence()
    {
        createHorizontalFence();
        createVerticalFence();
    }

    protected void
    createHorizontalFence()
    {
        for (int i = 0; i < width; ++i)
        {
            addEntity(new Fence(this), new Point(i, 0));
            addEntity(new Fence(this), new Point(i, height-1));
        }
    }

    protected void
    createVerticalFence()
    {
        // Horizontal fence takes care of the corners.
        for (int i = 1; i < height-1; ++i)
        {
            addEntity(new Fence(this), new Point(0, i));
            addEntity(new Fence(this), new Point(width-1, i));
        }
    }

    protected void
    createSheep()
    {
        for (int i = 0; i < numSheep; ++i)
        {
            Entity entity = new Sheep(this);
            addEntity(entity, getFreePosition(entity));
        }
    }

    public void
    run()
    {
        refresh();
    }

    public void
    refresh()
    {
        gui.update();
    }

    /**
     * Returns a random free position in the pasture if there exists
     * one.
     *
     * If the first random position turns out to be occupied, the rest
     * of the board is searched to find a free position.
     */
    private Point
    getFreePosition(Entity entity) throws MissingResourceException
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
            Boolean free = true;

            for (Entity occupant : getSpaceOccupants(pos))
            {
                if (!entity.mayShareSpaceWith(occupant))
                {
                    free = false;
                    break;
                }
            }

            if (free)
            {
                return pos;
            }
        }

        throw new MissingResourceException(
            "There is no free space left in the pasture",
            "Pasture",
            "");
    }

    public void
    addEntity(Entity entity, Point pos)
    {
        entities.add(entity);
        addSpaceOccupant(pos, entity);
        setEntityPosition(entity, pos);
        gui.addEntity(entity, pos);
    }

    public void
    moveEntity(Entity entity, Point newPos)
    {
        Point oldPos = getEntityPosition(entity);

        if (!removeSpaceOccupant(oldPos, entity))
        {
            throw new IllegalStateException(
                "Occupant to be removed was not an occupant!");
        }

        addSpaceOccupant(newPos, entity);
        setEntityPosition(entity, newPos);
        gui.moveEntity(entity, oldPos, newPos);
    }

    protected void
    addSpaceOccupant(Point pos, Entity entity)
    {
        getSpaceOccupants(pos).add(entity);
    }

    protected Boolean
    removeSpaceOccupant(Point pos, Entity entity)
    {
        return getSpaceOccupants(pos).remove(entity);
    }

    protected List<Entity>
    getSpaceOccupants(Point pos)
    {
        List<Entity> occupants = grid.get(pos);
        if (occupants == null)
        {
            occupants = new ArrayList<Entity>();
            grid.put(pos, occupants);
        }
        return occupants;
    }

    protected void
    setEntityPosition(Entity entity, Point pos)
    {
        points.put(entity, pos);
    }

    public Point
    getEntityPosition(Entity entity)
    {
        return points.get(entity);
    }

    protected void
    removeEntityPosition(Entity entity)
    {
        points.remove(entity);
    }

    public void
    removeEntity(Entity entity)
    {
        entities.remove(entity);

        Point pos = getEntityPosition(entity);
        removeSpaceOccupant(pos, entity);
        removeEntityPosition(entity);
        gui.removeEntity(entity, pos);
    }

    /**
     * Various methods for getting information about the pasture
     */

    public List<Entity>
    getEntities()
    {
        return new ArrayList<Entity>(entities);
    }

    public List<Point>
    getFreeNeighbours(Entity entity)
    {
        List<Point> free = new ArrayList<Point>();

        int entityX = getEntityPosition(entity).x;
        int entityY = getEntityPosition(entity).y;

        for (int x = -1; x <= 1; ++x)
        {
            for (int y = -1; y <= 1; ++y)
            {
                Point pos = new Point(entityX + x, entityY + y);
                if (freeSpace(pos, entity))
                {
                    free.add(pos);
                }
            }
        }

        return free;
    }

    private boolean
    freeSpace(Point pos, Entity entity)
    {
        for (Entity occupant : getSpaceOccupants(pos))
        {
            if (!occupant.mayShareSpaceWith(entity))
            {
                return false;
            }
        }
        return true;
    }
}
