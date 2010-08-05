/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.entity;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;
import pasture.*;
import pasture.behavior.*;

abstract public class Entity implements IEntity
{
    protected Pasture pasture;
    protected ImageIcon image;
    protected Collection<IBehavior> behaviors = new ArrayList<IBehavior>();

    public
    Entity(Pasture pasture, String imagePath)
    {
        this.pasture = pasture;
        this.image   = new ImageIcon(imagePath);
    }

    public void
    tick()
    {
        if (notRemoved())
        {
            act();
        }
    }

    protected void
    act()
    {
        for (IBehavior behavior : behaviors)
        {
            behavior.act();
        }
    }

    public void
    addBehavior(IBehavior behavior)
    {
        behaviors.add(behavior);
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

    public Boolean
    notRemoved()
    {
        return pasture.contains(this);
    }

    public void
    die()
    {
        pasture.removeEntity(this);
    }

    public Boolean
    mayStandAt(Point pos)
    {
        return pasture.isSafePosition(pos, this);
    }
}
