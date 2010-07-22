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
    private final Grid grid;
    private final Map<Entity, Point> positions = new HashMap<Entity, Point>();
    private final Gui gui;

    public
    Pasture()
    {
        grid = new Grid();

        Engine engine = new Engine(this);
        gui = new Gui(width, height, engine);

        createFence();
        createSheep();
    }

    private void
    createFence()
    {
        createHorizontalFence();
        createVerticalFence();
    }

    private void
    createHorizontalFence()
    {
        for (int i = 0; i < width; ++i)
        {
            addEntity(new Fence(this), new Point(i, 0));
            addEntity(new Fence(this), new Point(i, height-1));
        }
    }

    private void
    createVerticalFence()
    {
        // Horizontal fence takes care of corners.
        for (int i = 1; i < height-1; ++i)
        {
            addEntity(new Fence(this), new Point(0, i));
            addEntity(new Fence(this), new Point(width-1, i));
        }
    }

    private void
    createSheep()
    {
        for (int i = 0; i < numSheep; ++i)
        {
            Entity entity = new Sheep(this);
            addEntity(entity, getRandomPossiblePosition(entity));
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
     * Returns a random free position in the pasture if there exists one.
     *
     * If the first random position turns out to be occupied, the rest of the
     * board is searched to find a free position.
     */
    private Point
    getRandomPossiblePosition(Entity entity) throws MissingResourceException
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

            for (Entity occupant : grid.getOccupants(pos))
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
        grid.addOccupant(pos, entity);
        setEntityPosition(entity, pos);
        gui.addEntity(entity, pos);
    }

    public void
    moveEntity(Entity entity, Point newPos)
    {
        Point oldPos = getEntityPosition(entity);

        if (!grid.removeOccupant(oldPos, entity))
        {
            throw new IllegalStateException(
                "Occupant to be removed was not an occupant!");
        }

        grid.addOccupant(newPos, entity);
        setEntityPosition(entity, newPos);
        gui.moveEntity(entity, oldPos, newPos);
    }

    public void
    removeEntity(Entity entity)
    {
        Point pos = getEntityPosition(entity);

        entities.remove(entity);
        grid.removeOccupant(pos, entity);
        removeEntityPosition(entity);
        gui.removeEntity(entity, pos);
    }

    public List<Entity>
    getEntities()
    {
        return new ArrayList<Entity>(entities);
    }

    private void
    setEntityPosition(Entity entity, Point pos)
    {
        positions.put(entity, pos);
    }

    private Point
    getEntityPosition(Entity entity)
    {
        return positions.get(entity);
    }

    private void
    removeEntityPosition(Entity entity)
    {
        positions.remove(entity);
    }

    public List<Point>
    getPossibleNeighbours(Entity entity)
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
        for (Entity occupant : grid.getOccupants(pos))
        {
            if (!occupant.mayShareSpaceWith(entity))
            {
                return false;
            }
        }
        return true;
    }
}
