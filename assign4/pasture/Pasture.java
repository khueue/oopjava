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
    private final Grid grid = new Grid(width, height);
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
    contains(Entity entity)
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

    public Point
    getEntityPosition(Entity entity)
    {
        return positions.get(entity);
    }

    public List<Entity>
    getEntities()
    {
        return new ArrayList<Entity>(entities);
    }

    private Point
    getRandomSafePosition(Entity entity) throws MissingResourceException
    {
        return grid.getRandomSafePosition(entity);
    }

    public List<Point>
    getNearestPositions(Point origin, Integer radius)
    {
        return grid.getNearestPositions(origin, radius);
    }

    public List<Point>
    getNearestSafePositions(Entity entity, Integer radius)
    {
        return grid.getNearestSafePositions(entity, radius);
    }

    public List<Entity>
    getOtherEntitiesAtSamePosition(Entity entity)
    {
        return grid.getOtherEntitiesAtSamePosition(entity);
    }

    public Boolean
    isSafePosition(Point pos, Entity entity)
    {
        return grid.isSafePosition(pos, entity);
    }
}
