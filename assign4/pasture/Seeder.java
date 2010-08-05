/**
 * OOPJAVA ST10 - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.awt.Point;
import pasture.entity.*;

public class Seeder
{
    private final Integer numSheep     = 1;
    private final Integer numWolves    = 10;
    private final Integer numGrass     = 0;
    private final Integer numObstacles = 0;

    private final Pasture pasture;
    private final Integer width;
    private final Integer height;

    public
    Seeder(Pasture pasture, Integer width, Integer height)
    {
        this.pasture = pasture;
        this.width   = width;
        this.height  = height;
    }

    public void
    createEntities()
    {
        createFence();
        createObstacles();
        createGrass();
        createSheep();
        createWolves();
    }

    private void
    createFence()
    {
        createHorizontalFence();
        createVerticalFence();
    }

    private void
    createHorizontalFence()
    {
        for (int i = 0; i < width; ++i)
        {
            pasture.addEntity(new Fence(pasture), new Point(i, 0));
            pasture.addEntity(new Fence(pasture), new Point(i, height-1));
        }
    }

    private void
    createVerticalFence()
    {
        // Horizontal fence takes care of corners.
        for (int i = 1; i < height-1; ++i)
        {
            pasture.addEntity(new Fence(pasture), new Point(0, i));
            pasture.addEntity(new Fence(pasture), new Point(width-1, i));
        }
    }

    private void
    createObstacles()
    {
        for (int i = 0; i < numObstacles; ++i)
        {
            placeRandomly(new Fence(pasture));
        }
    }

    private void
    createGrass()
    {
        for (int i = 0; i < numGrass; ++i)
        {
            placeRandomly(new Grass(pasture));
        }
    }

    private void
    createSheep()
    {
        for (int i = 0; i < numSheep; ++i)
        {
            placeRandomly(new Sheep(pasture));
        }
    }

    private void
    createWolves()
    {
        for (int i = 0; i < numWolves; ++i)
        {
            placeRandomly(new Wolf(pasture));
        }
    }

    private void
    placeRandomly(IEntity entity)
    {
        Point random = pasture.getRandomSafePosition(entity);
        pasture.addEntity(entity, random);
    }
}
