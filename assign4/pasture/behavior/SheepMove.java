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
    SheepMove()
    {
        super(8);
    }

    public void
    act(IEntity entity)
    {
        if (timeToAct())
        {
            Pasture pasture = entity.getPasture();
            List<Point> nearest = pasture.getNearestPositions(entity, 1);
            if (!nearest.isEmpty())
            {
                Map<Point, Integer> weights = new HashMap<Point, Integer>();
                if (wolfInSight(nearest))
                {
                    moveInOppositeDirectionTo();
                }
                else if ()
                {
                    
                }
            }
        }
    }
}
