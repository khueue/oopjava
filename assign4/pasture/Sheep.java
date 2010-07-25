/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Sheep extends Entity
{
    public
    Sheep(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/sheep.gif"));
        behaviors.add(new SheepMove());
        behaviors.add(new SheepEat());
        behaviors.add(new SheepReproduce());
    }

    public Boolean
    mayEat(Entity entity)
    {
        return entity instanceof Grass;
    }

    public Boolean
    maySharePositionWith(Entity entity)
    {
        return (entity instanceof Grass);
    }
}
