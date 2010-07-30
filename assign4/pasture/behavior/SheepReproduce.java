/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class SheepReproduce extends Reproduce
{
    public
    SheepReproduce(IEntity entity)
    {
        super(entity);
        setTriggerPeriod(101);
    }
}
