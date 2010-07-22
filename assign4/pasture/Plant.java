/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.*;
import javax.swing.*;

abstract public class Plant extends Entity
{
    public
    Plant(Pasture pasture, ImageIcon image)
    {
        super(pasture, image);
    }

    public Boolean
    maySharePositionWith(Entity entity)
    {
        return !(entity instanceof Fence);
    }
}
