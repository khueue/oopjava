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
        triggerAfter(8);
    }

    public void
    actNow()
    {
        /** /
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        map.put("Seb",   25);
        map.put("Jon",   30);
        map.put("Stina", 26);
        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String,Integer> pair = it.next();
            String key    = pair.getKey();
            Integer value = pair.getValue();
            System.out.println("key: " + key + ", value: " + value);
        }
        // CollectionsSSSS.max
        /**/

        List<Point> nearest = pasture.getNearestPositions(entity, 1);
        if (!nearest.isEmpty())
        {
            Map<Point,Integer> weights = initializeWeightMap(nearest);
            Iterator<Map.Entry<Point,Integer>> it = weights.entrySet().iterator();
            while (it.hasNext())
            {
                weighPoint(it.next());
            }

            it = weights.entrySet().iterator();
            Map.Entry<Point,Integer> maxpair = it.next();
            while (it.hasNext())
            {
                Map.Entry<Point,Integer> pair = it.next();
                Point pos = pair.getKey();
                Integer weight = pair.getValue();
                if (weight > maxpair.getValue())
                {
                    maxpair = pair;
                }
            }

            if (entity.getPosition().equals(maxpair.getKey()))
            {
                Point pos = Util.getRandomMember(nearest);
                pasture.moveEntity(entity, pos);
            }
            else
            {
                pasture.moveEntity(entity, maxpair.getKey());
            }
        }
        else
        {
            System.out.println("no empty positions");
        }
    }

    private void
    weighPoint(Map.Entry<Point,Integer> pair)
    {
        // System.out.println(pair.getKey() + " = " + pair.getValue());
        Point pos = pair.getKey();
        Integer weight = pair.getValue();
        List<IEntity> occupants = pasture.getOccupants(pos);
        if (!occupants.isEmpty())
        {
            IEntity occ = occupants.get(0);
            if (occ instanceof Wolf)
            {
                pair.setValue(weight - 100);
            }
            else if (occ instanceof Grass)
            {
                pair.setValue(weight + 100);
                //System.out.println("incr " + pair.getValue());
            }
            else if (occ instanceof Fence)
            {
                pair.setValue(weight - 10000);
            }
        }
    }

    private Map<Point,Integer>
    initializeWeightMap(List<Point> nearest)
    {
        Map<Point,Integer> weights = new HashMap<Point,Integer>();
        for (Point pos : nearest)
        {
            weights.put(pos, 0);
        }
        return weights;
    }
}
