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
    private Integer reach;

    public
    Move(IEntity entity)
    {
        super(entity);
    }

    protected void
    setVisibility(Integer range)
    {
        this.visibility = range;
    }

    protected void
    setReach(Integer range)
    {
        this.reach = range;
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
                pasture.moveEntity(entity, newPos);
            }
        }
    }

    private Map<Point,Double>
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

    private List<Point>
    selectCandidatePositions(Map<Point,Double> weightMap)
    {
        Map<Point,Double> candidates;
        candidates = keepOnlySafeAndReachable(weightMap);
        candidates = keepOnlyBest(candidates);
        List<Point> positions = new ArrayList<Point>(candidates.keySet());
        return positions;
    }

    protected Map<Point,Double>
    keepOnlySafeAndReachable(Map<Point,Double> weightMap)
    {
        Map<Point,Double> result = new HashMap<Point,Double>();
        List<Point> safe = pasture.getNearestSafePositions(entity, reach);
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
        return result;
    }
}
