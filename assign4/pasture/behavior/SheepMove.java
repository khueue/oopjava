/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

public class SheepMove extends Move
{
    public
    SheepMove(IEntity entity)
    {
        super(entity);
        triggerAfter(5);
        setVisibility(3);
        setReach(1);
    }

    protected Double
    evaluatePosition(Point origin, List<Point> visible)
    {
        Double wolf = distanceToClosestEntity(origin, visible, Wolf.class);
        Double food = distanceToClosestEntity(origin, visible, Grass.class);
        return 100.0*wolf - food;
    }
}
