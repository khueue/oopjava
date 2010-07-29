/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.entity;

import java.awt.Point;
import javax.swing.ImageIcon;
import pasture.*;
import pasture.behavior.*;

public interface IEntity
{
    public void
    tick();

    public IEntity
    spawnChild();

    public Pasture
    getPasture();

    public ImageIcon
    getImage();

    public Point
    getPosition();

    public Boolean
    notRemoved();

    public void
    die();

    public Boolean
    maySharePositionWith(IEntity entity);

    public Boolean
    mayStandAt(Point pos);
}
