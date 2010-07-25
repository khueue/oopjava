/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.entity;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;
import pasture.*;
import pasture.behavior.*;

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
    maySharePositionWith(IEntity entity)
    {
        return (entity instanceof Grass);
    }
}
