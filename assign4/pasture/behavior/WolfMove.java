/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class WolfMove extends Move
{
    public
    WolfMove(IEntity entity)
    {
        super(entity);
        triggerAfter(Config.get("wolf.move.after"));
        setVisibility(Config.get("wolf.visibility"));
    }

    protected Double
    evaluatePosition(Point origin, List<Point> visible)
    {
        Double food = distanceToClosestEntity(origin, visible, Sheep.class);
        Double prev = distanceToPreviousPosition(origin);
        return (-1.0 * food) + (0.1 * prev);
    }
}
