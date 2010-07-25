/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.*;

abstract public class Entity implements IEntity
{
    protected Pasture pasture;
    protected ImageIcon image;
    protected Collection<IBehavior> behaviors = new ArrayList<IBehavior>();

    public
    Entity(Pasture pasture, ImageIcon image)
    {
        this.pasture = pasture;
        this.image   = image;
    }

    public Pasture
    getPasture()
    {
        return pasture;
    }

    public ImageIcon
    getImage()
    {
        return image;
    }

    public void
    tick()
    {
        if (notRemoved())
        {
            for (IBehavior behavior : behaviors)
            {
                behavior.behave(this);
            }
        }
    }

    public Boolean
    notRemoved()
    {
        return pasture.contains(this);
    }

    public Point
    getPosition()
    {
        return pasture.getEntityPosition(this);
    }

    public Boolean
    mayStandAt(Point pos)
    {
        return pasture.isSafePosition(pos, this);
    }
}
