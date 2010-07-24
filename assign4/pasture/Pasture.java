/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;

public class Pasture
{
    private final Integer width = 35;
    private final Integer height = 24;

    private final Integer numSheep = 3;
    private final Integer numWolves = 10;
    private final Integer numGrass = 100;

    private final Set<Entity> entities = new HashSet<Entity>();
    private final Grid grid = new Grid();
    private final Map<Entity, Point> positions = new HashMap<Entity, Point>();
    private final Gui gui;

    public
    Pasture()
    {
        gui = new Gui(width, height, new Engine(this));

        // Order of creation determines what is visible.
        createFence();
        createGrass();
        createSheep();
        createWolves();
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
            addEntity(entity, getRandomSafePosition(entity));
        }
    }

    private void
    createWolves()
    {
        for (int i = 0; i < numWolves; ++i)
        {
            Entity entity = new Wolf(this);
            addEntity(entity, getRandomSafePosition(entity));
        }
    }

    private void
    createGrass()
    {
        for (int i = 0; i < numGrass; ++i)
        {
            Entity entity = new Grass(this);
            addEntity(entity, getRandomSafePosition(entity));
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

    public Boolean
    includes(Entity entity)
    {
        return entity.getPosition() != null;
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
        Point pos = entity.getPosition();

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

    private Point
    getRandomSafePosition(Entity entity) throws MissingResourceException
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
    getNearestPositions(Point origin, Integer range)
    {
        List<Point> nearest = new ArrayList<Point>();
        for (int x = -range; x <= range; ++x)
        {
            for (int y = -range; y <= range; ++y)
            {
                Point pos = new Point(origin.x + x, origin.y + y);
                nearest.add(pos);
            }
        }
        return nearest;
    }

    public List<Point>
    getNearestSafePositions(Entity entity, Integer range)
    {
        Point pos = entity.getPosition();
        List<Point> nearest = getNearestPositions(pos, range);
        return removeNonSafePositions(nearest, entity);
    }

    private List<Point>
    removeNonSafePositions(List<Point> positions, Entity entity)
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

    public Point
    getEntityPosition(Entity entity)
    {
        return positions.get(entity);
    }

    public List<Entity>
    getOtherEntitiesAtSamePosition(Entity entity)
    {
        List<Entity> others = new ArrayList<Entity>();
        for (Entity occupant : grid.getOccupants(entity.getPosition()))
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
