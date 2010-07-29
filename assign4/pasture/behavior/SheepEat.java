/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class SheepEat extends Eat
{
    public
    SheepEat(IEntity entity)
    {
        super(entity);
        starveAfter(100);
    }

    public Boolean
    mayEat(IEntity entity)
    {
        return (entity instanceof Grass);
    }
}
