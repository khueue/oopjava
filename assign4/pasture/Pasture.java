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
    getFreePosition(Entity toPlace) throws MissingResourceException
    {
        Point position = new Point(
            (int)(Math.random() * width),
            (int)(Math.random() * height));

        int p = position.x + (position.y * width);
        int m = height * width;
        int q = 97; // Any large prime will do.

        for (int i = 0; i < m; ++i)
        {
            int j = (p + i*q) % m;
            int x = j % width;
            int y = j / width;

            position = new Point(x,y);
            boolean free = true;

            Collection<Entity> c = getEntitiesAt(position);
            if (c != null)
            {
                for (Entity thisThing : c)
                {
                    if (!toPlace.mayShareSpaceWith(thisThing))
                    {
                        free = false;
                        break;
                    }
                }
            }

            if (free)
            {
                return position;
            }
        }

        throw new MissingResourceException(
            "There is no free space left in the pasture",
            "Pasture",
            "");
    }

    public Point
    getPosition(Entity entity)
    {
        return points.get(entity);
    }

    /**
     * Add a new entity to the pasture.
     */
    public void
    addEntity(Entity entity, Point pos)
    {
        entities.add(entity);

        List<Entity> list = grid.get(pos);
        if (list == null)
        {
            list = new ArrayList<Entity>();
            grid.put(pos, list);
        }
        list.add(entity);

        points.put(entity,pos);

        gui.addEntity(entity, pos);
    }

    public void
    moveEntity(Entity entity, Point newPos)
    {
        Point oldPos = points.get(entity);
        List<Entity> list = grid.get(oldPos);
        if (!list.remove(entity))
        {
            throw new IllegalStateException("Inconsistent state in Pasture");
        }
        /* We expect the entity to be at its old position, before we
           move, right? */

        list = grid.get(newPos);
        if (list == null)
        {
            list = new ArrayList<Entity>();
            grid.put(newPos, list);
        }
        list.add(entity);

        points.put(entity, newPos);

        gui.moveEntity(entity, oldPos, newPos);
    }

    /**
     * Remove the specified entity from this pasture.
     */
    public void
    removeEntity(Entity entity)
    {
        Point p = points.get(entity);
        entities.remove(entity);
        grid.get(p).remove(entity);
        points.remove(entity);
        gui.removeEntity(entity, p);
    }

    /**
     * Various methods for getting information about the pasture
     */

    public List<Entity>
    getEntities()
    {
        return new ArrayList<Entity>(entities);
    }

    public Collection<Entity>
    getEntitiesAt(Point point)
    {
        Collection<Entity> coll = grid.get(point);
        return (coll == null) ? null : new ArrayList<Entity>(coll);
    }

    public List<Point>
    getFreeNeighbours(Entity entity)
    {
        List<Point> free = new ArrayList<Point>();

        int entityX = getEntityPosition(entity).x;
        int entityY = getEntityPosition(entity).y;

        for (int x = -1; x <= 1; x++)
        {
            for (int y = -1; y <= 1; y++)
            {
                Point p = new Point(entityX + x, entityY + y);
                if (freeSpace(p, entity))
                {
                    free.add(p);
                }
            }
        }

        return free;
    }

    private boolean
    freeSpace(Point p, Entity e)
    {
        List <Entity> list = grid.get(p);
        if (list == null)
        {
            return true;
        }

        for (Entity old : list)
        {
            if (!old.mayShareSpaceWith(e))
            {
                return false;
            }
        }
        return true;
    }

    public Point
    getEntityPosition(Entity entity)
    {
        return points.get(entity);
    }
}
