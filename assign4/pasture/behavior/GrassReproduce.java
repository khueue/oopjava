/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class GrassReproduce extends Reproduce
{
    public
    GrassReproduce(IEntity entity)
    {
        super(entity);
        reproduceAfter(Config.get("grass.reproduce.after"));
    }
}
