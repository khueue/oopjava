/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class WolfEat extends Eat
{
    public
    WolfEat(IEntity entity)
    {
        super(entity);
    }

    public Boolean
    mayEat(IEntity entity)
    {
        return (entity instanceof Sheep);
    }
}
