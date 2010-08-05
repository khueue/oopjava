/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class WolfReproduce extends Reproduce
{
    public
    WolfReproduce(IEntity entity)
    {
        super(entity);
        reproduceAfter(Config.get("wolf.reproduce.after"));
    }

    protected IEntity
    spawnChild()
    {
        return new Wolf(entity.getPasture());
    }
}
