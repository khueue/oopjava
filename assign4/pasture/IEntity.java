/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public interface IEntity
{
    public void
    tick();

    public ImageIcon
    getImage();

    public Boolean
    maySharePositionWith(Entity entity);
}
