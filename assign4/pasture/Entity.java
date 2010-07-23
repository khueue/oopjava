/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.*;
import javax.swing.*;

abstract public class Entity extends JFrame implements IEntity
{
    protected final Pasture pasture;
    protected final ImageIcon image;

    public
    Entity(Pasture pasture, ImageIcon image)
    {
        this.pasture = pasture;
        this.image   = image;
    }

    public Boolean
    isRemoved()
    {
        return getPosition() == null;
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
        return pasture.isFreePosition(pos, this);
    }
}
