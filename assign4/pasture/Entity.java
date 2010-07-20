/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import javax.swing.*;
import java.awt.*;
import java.util.*;

abstract public class Entity implements IEntity
{
    protected Pasture pasture;
    protected ImageIcon image;

    public
    Entity(Pasture pasture, ImageIcon image)
    {
        this.pasture = pasture;
        this.image   = image;
    }

    public ImageIcon
    getImage()
    {
        return image;
    }

    public Boolean
    mayShareSpaceWith(Entity entity)
    {
        return false;
    }
}
