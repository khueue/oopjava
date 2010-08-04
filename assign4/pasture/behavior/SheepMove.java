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
    public static final Integer VISIBILITY = 3;
    public static final Integer REACH      = 1;

    public
    SheepMove(IEntity entity)
    {
        super(entity);
        triggerAfter(5);
    }

    // visible, reasonable/possible
    public void
    actNow()
    {
        List<Point> visible = pasture.getNearestPositions(entity, VISIBILITY);
        if (visible.size() > 0)
        {
            Map<Point,Double> weightMap = calculateWeights(visible);
            List<Point> candidates = selectBestPositions(weightMap);
            if (candidates.size() > 0)
            {
                Point newPos = Util.getRandomMember(candidates);
                pasture.moveEntity(entity, newPos);
            }
        }
    }

    private Map<Point,Double>
    calculateWeights(List<Point> positions)
    {
        Map<Point,Double> results = new HashMap<Point,Double>();
        for (Point pos : positions)
        {
            Double weight = evaluatePosition(pos, positions);
            results.put(pos, weight);
        }
        return results;
    }

    private List<Point>
    selectBestPositions(Map<Point,Double> weights)
    {
        Map<Point,Double> candidates;
        candidates = keepOnlySafe(weights);
        candidates = keepOnlyBest(candidates);
        return new ArrayList<Point>(candidates.keySet());
    }

    private Double
    evaluatePosition(Point origin, List<Point> visible)
    {
        Double w = distanceToClosestEntity(origin, visible, Wolf.class);
        Double f = distanceToClosestEntity(origin, visible, Grass.class);
        return 100.0*w - f;
    }

    private Map<Point,Double>
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

    private Map<Point,Double>
    keepOnlySafe(Map<Point,Double> weightMap)
    {
        Map<Point,Double> result = new HashMap<Point,Double>();
        List<Point> safe = pasture.getNearestSafePositions(entity, REACH);
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

    private Double
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

    private Boolean
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
}
