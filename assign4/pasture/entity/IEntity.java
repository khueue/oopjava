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

public interface IEntity
{
    public void
    tick();

    public Pasture
    getPasture();

    public ImageIcon
    getImage();

    public Point
    getPosition();

    public Boolean
    maySharePositionWith(IEntity entity);

    public Boolean
    mayStandAt(Point pos);
}
