/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.entity;

import java.util.*;
import java.awt.Point;
import javax.swing.*;
import pasture.*;
import pasture.behavior.*;

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

    public Point
    getPosition()
    {
        return pasture.getEntityPosition(this);
    }

    private Boolean
    notRemoved()
    {
        return pasture.contains(this);
    }

    public Boolean
    mayStandAt(Point pos)
    {
        return pasture.isSafePosition(pos, this);
    }
}
