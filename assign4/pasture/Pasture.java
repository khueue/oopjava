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

    private final Set<IEntity> entities = new HashSet<IEntity>();
    private final Grid grid;
    private final Map<IEntity, Point> positions = new HashMap<IEntity, Point>();
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
    contains(IEntity entity)
    {
        return entity.getPosition() != null;
    }

    public void
    addEntity(IEntity entity, Point pos)
    {
        entities.add(entity);
        grid.addOccupant(pos, entity);
        positions.put(entity, pos);
        gui.addEntity(entity, pos);
    }

    public void
    removeEntity(IEntity entity)
    {
        Point pos = entity.getPosition();
        entities.remove(entity);
        grid.removeOccupant(pos, entity);
        positions.remove(entity);
        gui.removeEntity(entity, pos);
    }

    public void
    moveEntity(IEntity entity, Point newPos)
    {
        removeEntity(entity);
        addEntity(entity, newPos);
    }

    public Point
    getEntityPosition(IEntity entity)
    {
        return positions.get(entity);
    }

    public List<IEntity>
    getEntities()
    {
        return new ArrayList<IEntity>(entities);
    }

    public Point
    getRandomSafePosition(IEntity entity)
    {
        return grid.getRandomSafePosition(entity);
    }

    public List<Point>
    getNearestPositions(Point origin, Integer radius)
    {
        return grid.getNearestPositions(origin, radius);
    }

    public List<Point>
    getNearestSafePositions(IEntity entity, Integer radius)
    {
        return grid.getNearestSafePositions(entity, radius);
    }

    public List<IEntity>
    getOtherEntitiesAtSamePosition(IEntity entity)
    {
        return grid.getOtherEntitiesAtSamePosition(entity);
    }

    public Boolean
    isSafePosition(Point pos, IEntity entity)
    {
        return grid.isSafePosition(pos, entity);
    }
}
