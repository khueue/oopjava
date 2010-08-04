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
    public static final Integer VISIBILITY = 2;
    public static final Integer REACH      = 1;

    public
    SheepMove(IEntity entity)
    {
        super(entity);
        triggerAfter(5);
    }

    public void
    actNow()
    {
        List<Point> visible = pasture.getNearestPositions(entity, VISIBILITY);
        if (visible.size() > 0)
        {
            List<WeightedPoint> weights = calculateWeights(visible);
            List<Point> candidates = selectBestPositions(weights);
            if (candidates.size() > 0)
            {
                Point newPos = Util.getRandomMember(candidates);
                pasture.moveEntity(entity, newPos);
            }
        }
    }

    private List<Point>
    selectBestPositions(List<WeightedPoint> weights)
    {
        List<Point> candidates;
        candidates = includeOnlyBest(weights);
        candidates = includeOnlySafe(candidates);
        return candidates;
    }

    private List<Point>
    includeOnlyBest(List<WeightedPoint> candidates)
    {
        return WeightedPoint.getHeaviestPoints(candidates);
    }

    private List<Point>
    includeOnlySafe(List<Point> candidates)
    {
        List<Point> safe = pasture.getNearestSafePositions(entity, REACH);
        return Util.intersection(candidates, safe);
    }

    private List<WeightedPoint>
    calculateWeights(List<Point> positions)
    {
        List<WeightedPoint> weights = new ArrayList<WeightedPoint>();
        for (Point pos : positions)
        {
            WeightedPoint weightedPos = new WeightedPoint(pos);
            evaluatePoint(weightedPos, positions);
            weights.add(weightedPos);
        }
        return weights;
    }

    private void
    evaluatePoint(WeightedPoint pos, List<Point> nearest)
    {
        Double w = distanceToClosestWolf(pos, nearest);
        Double f = distanceToClosestFood(pos, nearest);
        pos.setWeight(100.0*w - f);
    }

    private Double
    distanceToClosestWolf(Point origin, List<Point> positions)
    {
        Double closest = Double.MAX_VALUE;
        for (Point point : positions)
        {
            List<IEntity> occupants = pasture.getOccupants(point);
            if (containsWolf(occupants))
            {
                Double distance = origin.distance(point);
                if (distance < closest)
                {
                    closest = distance;
                }
            }
        }
        return (closest < Double.MAX_VALUE) ? closest : 0.0;
    }

    private Double
    distanceToClosestFood(Point origin, List<Point> positions)
    {
        Double closest = Double.MAX_VALUE;
        for (Point point : positions)
        {
            List<IEntity> occupants = pasture.getOccupants(point);
            if (containsGrass(occupants))
            {
                Double distance = origin.distance(point);
                if (distance < closest)
                {
                    closest = distance;
                }
            }
        }
        return (closest < Double.MAX_VALUE) ? closest : 0.0;
    }

    private Boolean
    containsWolf(List<IEntity> entities)
    {
        for (IEntity entity : entities)
        {
            if (entity instanceof Wolf)
            {
                return true;
            }
        }
        return false;
    }

    private Boolean
    containsGrass(List<IEntity> entities)
    {
        for (IEntity entity : entities)
        {
            if (entity instanceof Grass)
            {
                return true;
            }
        }
        return false;
    }
}
