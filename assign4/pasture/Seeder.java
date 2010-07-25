/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.awt.Point;
import pasture.entity.*;

public class Seeder
{
    private final Integer numSheep     = 20;
    private final Integer numWolves    = 10;
    private final Integer numGrass     = 40;
    private final Integer numObstacles = 40;

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
            IEntity entity = new Fence(pasture);
            pasture.addEntity(entity, pasture.getRandomSafePosition(entity));
        }
    }

    private void
    createGrass()
    {
        for (int i = 0; i < numGrass; ++i)
        {
            IEntity entity = new Grass(pasture);
            pasture.addEntity(entity, pasture.getRandomSafePosition(entity));
        }
    }

    private void
    createSheep()
    {
        for (int i = 0; i < numSheep; ++i)
        {
            IEntity entity = new Sheep(pasture);
            pasture.addEntity(entity, pasture.getRandomSafePosition(entity));
        }
    }

    private void
    createWolves()
    {
        for (int i = 0; i < numWolves; ++i)
        {
            IEntity entity = new Wolf(pasture);
            pasture.addEntity(entity, pasture.getRandomSafePosition(entity));
        }
    }
}
