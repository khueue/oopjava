/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture.behavior;

import java.util.*;
import java.awt.Point;
import pasture.*;
import pasture.entity.*;

abstract public class Move extends Behavior
{
    private Integer visibility;
    private Point previous;

    public
    Move(IEntity entity)
    {
        super(entity);
    }

    protected void
    moveAfter(Integer period)
    {
        triggerAfter(period);
    }

    protected Point
    getPreviousPosition()
    {
        Boolean notMovedYet = (previous == null);
        return notMovedYet ? entity.getPosition() : previous;
    }

    protected void
    setVisibility(Integer range)
    {
        this.visibility = range;
    }

    public void
    actNow()
    {
        List<Point> visible = pasture.getNearestPositions(entity, visibility);
        if (visible.size() > 0)
        {
            Map<Point,Double> weightMap = calculateWeightMap(visible);
            List<Point> candidates = selectCandidatePositions(weightMap);
            if (candidates.size() > 0)
            {
                Point newPos = Util.getRandomMember(candidates);
                updatePosition(newPos);
            }
        }
    }

    protected void
    updatePosition(Point newPos)
    {
        previous = entity.getPosition();
        pasture.moveEntity(entity, newPos);
    }

    protected Map<Point,Double>
    calculateWeightMap(List<Point> positions)
    {
        Map<Point,Double> results = new HashMap<Point,Double>();
        for (Point pos : positions)
        {
            Double weight = evaluatePosition(pos, positions);
            results.put(pos, weight);
        }
        return results;
    }

    abstract protected Double
    evaluatePosition(Point origin, List<Point> visible);

    protected Double
    distanceToClosestEntity(Point origin, List<Point> positions, Class klass)
    {
        Double closest = Double.MAX_VALUE;
        for (Point point : positions)
        {
            List<IEntity> occupants = pasture.getOccupants(point);
            if (containsEntity(occupants, klass))
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

    protected Double
    distanceToPreviousPosition(Point origin)
    {
        return origin.distance(getPreviousPosition());
    }

    protected Boolean
    containsEntity(List<IEntity> entities, Class klass)
    {
        for (IEntity entity : entities)
        {
            if (klass.isInstance(entity))
            {
                return true;
            }
        }
        return false;
    }

    protected List<Point>
    selectCandidatePositions(Map<Point,Double> weightMap)
    {
        weightMap = keepOnlySafeAndReachable(weightMap);
        weightMap = keepOnlyBest(weightMap);
        List<Point> positions = new ArrayList<Point>(weightMap.keySet());
        return positions;
    }

    protected Map<Point,Double>
    keepOnlySafeAndReachable(Map<Point,Double> weightMap)
    {
        Map<Point,Double> result = new HashMap<Point,Double>();
        List<Point> safe = pasture.getNearestSafePositions(entity, 1);
        for (Map.Entry<Point,Double> pair : weightMap.entrySet())
        {
            Point pos = pair.getKey();
            if (safe.contains(pos))
            {
                Double weight = pair.getValue();
                result.put(pos, weight);
            }
        }
        return result;
    }

    protected Map<Point,Double>
    keepOnlyBest(Map<Point,Double> weightMap)
    {
        Map<Point,Double> result = new HashMap<Point,Double>();
        if (weightMap.size() > 0)
        {
            Double max = Collections.max(weightMap.values());
            for (Map.Entry<Point,Double> pair : weightMap.entrySet())
            {
                Double weight = pair.getValue();
                if (weight >= max)
                {
                    Point pos = pair.getKey();
                    result.put(pos, weight);
                }
            }
        }
        return result;
    }
}
