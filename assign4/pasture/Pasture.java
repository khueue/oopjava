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

    private final Set<Entity> entities = new HashSet<Entity>();
    private final Grid grid;
    private final Map<Entity, Point> positions = new HashMap<Entity, Point>();
    private final Gui gui;

    public
    Pasture()
    {
        grid = new Grid(width, height);
        gui  = new Gui(width, height, new Engine(this));

        Seeder seeder = new Seeder(this, width, height);
        seeder.createEntities();
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

    public Point
    getRandomSafePosition(Entity entity)
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
