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
    protected Integer ticksUntilReproduce = Util.randomIntegerBetween(100, 140);

    public
    Entity(Pasture pasture, ImageIcon image)
    {
        this.pasture = pasture;
        this.image   = image;
    }

    public void
    tick()
    {
        if (!isRemoved())
        {
            move();
            eat();
            reproduce();
        }
    }

    private void
    move()
    {
    }

    private void
    eat()
    {
    }

    public void
    reproduce()
    {
        if (--ticksUntilReproduce == 0)
        {
            List<Point> safe = pasture.getNearestSafePositions(this, 1);
            if (safe.size() > 0)
            {
                Point pos = Util.getRandomMember(safe);
                pasture.addEntity(createOwnInstance(), pos);
            }

            ticksUntilReproduce = Util.randomIntegerBetween(100, 140);
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
    isRemoved()
    {
        // Hack, but works.
        return !pasture.includes(this);
    }

    public ImageIcon
    getImage()
    {
        return image;
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
