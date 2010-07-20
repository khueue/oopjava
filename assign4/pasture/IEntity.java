/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public interface IEntity
{
    public void
    tick();

    public ImageIcon
    getImage();

    public Boolean
    mayShareSpaceWith(Entity entity);
}
