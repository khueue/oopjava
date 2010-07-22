/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;

public class Pasture
{
    private final int width = 20;
    private final int height = 20;

    private final int numSheep = 15;
    private final int numWolves = 10;
    private final int numGrass = 100;

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
        createWolves();
        createGrass();
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
            addEntity(entity, getRandomFreePosition(entity));
        }
    }

    private void
    createWolves()
    {
        /** /
        for (int i = 0; i < numWolves; ++i)
        {
            Entity entity = new Wolf(this);
            addEntity(entity, getRandomFreePosition(entity));
        }
        /**/
    }

    private void
    createGrass()
    {
        for (int i = 0; i < numGrass; ++i)
        {
            Entity entity = new Grass(this);
            addEntity(entity, getRandomFreePosition(entity));
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

    private Point
    getRandomFreePosition(Entity entity) throws MissingResourceException
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
            if (isFreePosition(pos, entity))
            {
                return pos;
            }
        }

        throw new MissingResourceException(
            "There is no free space left in the pasture!",
            "Pasture",
            "");
    }

    public void
    addEntity(Entity entity, Point pos)
    {
        entities.add(entity);
        grid.addOccupant(pos, entity);
        positions.put(entity, pos);
        gui.addEntity(entity, pos);
    }

    public void
    removeEntity(Entity entity)
    {
        Point pos = positions.get(entity);
        entities.remove(entity);
        grid.removeOccupant(pos, entity);
        positions.remove(entity);
        gui.removeEntity(entity, pos);
    }

    public void
    moveEntity(Entity entity, Point newPos)
    {
        removeEntity(entity);
        addEntity(entity, newPos);
    }

    public List<Entity>
    getEntities()
    {
        return new ArrayList<Entity>(entities);
    }

    public List<Point>
    getFreeAdjacentPositions(Entity entity)
    {
        List<Point> free = new ArrayList<Point>();

        Point origin = positions.get(entity);

        for (int x = -1; x <= 1; ++x)
        {
            for (int y = -1; y <= 1; ++y)
            {
                // You are not adjacent to yourself.
                if (!(x == 0 && y == 0))
                {
                    Point pos = new Point(origin.x + x, origin.y + y);
                    if (entity.mayStandAt(pos))
                    {
                        free.add(pos);
                    }
                }
            }
        }

        return free;
    }

    public List<Entity>
    getFriends(Entity entity) // XXXXXXX rename
    {
        List<Entity> friends = new ArrayList<Entity>();
        for (Entity occupant : grid.getOccupants(positions.get(entity)))
        {
            if (occupant != entity)
            {
                friends.add(occupant);
            }
        }
        return friends;
    }

    public Boolean
    isFreePosition(Point pos, Entity entity)
    {
        for (Entity occupant : grid.getOccupants(pos))
        {
            if (!entity.maySharePositionWith(occupant))
            {
                return false;
            }
        }

        return true;
    }
}
