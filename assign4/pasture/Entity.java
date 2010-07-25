/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.*;
import java.lang.reflect.Constructor;

abstract public class Entity extends JFrame implements IEntity
{
    protected final Pasture pasture;
    protected final ImageIcon image;
    protected Integer ticksUntilReproduce = Util.randomIntegerBetween(50, 140);
    protected Integer ticksUntilMove = Util.randomIntegerBetween(5, 12);

    public
    Entity(Pasture pasture, ImageIcon image)
    {
        this.pasture = pasture;
        this.image   = image;
    }

    private void
    move()
    {
    }

    public void
    eat()
    {
        List<Entity> victims = pasture.getOtherEntitiesAtSamePosition(this);
        for (Entity victim : victims)
        {
            if (mayEat(victim))
            {
                // get food points also XXXXX
                pasture.removeEntity(victim);
            }
        }
    }

    public Boolean
    mayEat(Entity entity)
    {
        Boolean veg  = isHerbivore() && entity.isVegetable();
        Boolean meat = isCarnivore() && entity.isAnimal();
        return veg || meat;
    }

    public Boolean
    isAnimal()
    {
        return false;
    }

    public Boolean
    isVegetable()
    {
        return false;
    }

    public Boolean
    isHerbivore()
    {
        return false;
    }

    public Boolean
    isCarnivore()
    {
        return false;
    }

    public void
    reproduce()
    {
        if (--ticksUntilReproduce == 0)
        {
            ticksUntilReproduce = Util.randomIntegerBetween(100, 140);

            List<Point> safe = pasture.getNearestSafePositions(this, 1);
            if (safe.size() > 0)
            {
                Point pos = Util.getRandomMember(safe);
                pasture.addEntity(createOwnInstance(), pos);
            }
        }
    }

    public Entity
    createOwnInstance()
    {
        try
        {
            Class[] argTypes = new Class[] { pasture.getClass() };
            Constructor constructor = getClass().getConstructor(argTypes);
            Object[] args = new Object[] { pasture };
            return (Entity)constructor.newInstance(args);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public Boolean
    notRemoved()
    {
        return pasture.contains(this);
    }

    public ImageIcon
    getImage()
    {
        return image;
    }

    public Point
    getPosition()
    {
        return pasture.getEntityPosition(this);
    }

    public Boolean
    maySharePositionWith(Entity entity)
    {
        return false;
    }

    public Boolean
    mayStandAt(Point pos)
    {
        return pasture.isSafePosition(pos, this);
    }
}
