/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Wolf extends Entity
{
    public
    Wolf(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/wolf.gif"));
        behaviors.add(new WolfMove());
        behaviors.add(new WolfEat());
        behaviors.add(new WolfReproduce());
    }

    public Boolean
    mayEat(Entity entity)
    {
        return entity instanceof Sheep;
    }

    public Boolean
    maySharePositionWith(Entity entity)
    {
        return (entity instanceof Grass)
            || (entity instanceof Sheep);
    }
}
