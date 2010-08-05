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
        triggerAfter(Config.get("sheep.move.after"));
        setVisibility(Config.get("sheep.visibility"));
    }

    protected Double
    evaluatePosition(Point origin, List<Point> visible)
    {
        Double wolf = distanceToClosestEntity(origin, visible, Wolf.class);
        Double food = distanceToClosestEntity(origin, visible, Grass.class);
        Double prev = distanceToPreviousPosition(origin);
        return (100.0 * wolf) + (-1.0 * food) + (0.1 * prev);
    }
}
