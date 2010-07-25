/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Grass extends Entity
{
    public
    Grass(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/plant.gif"));
        behaviors.add(new GrassReproduce());
    }

    public Boolean
    maySharePositionWith(Entity entity)
    {
        return (entity instanceof Wolf)
            || (entity instanceof Sheep);
    }
}
