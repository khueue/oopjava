/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.entity;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import pasture.*;
import pasture.behavior.*;

public class Fence extends Entity
{
    public
    Fence(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/fence.gif"));
    }

    public Boolean
    maySharePositionWith(IEntity entity)
    {
        return false;
    }
}
