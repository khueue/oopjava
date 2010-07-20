/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.*;
import javax.swing.*;

// Note that Dummy is a pretty BAD example of object-oriented
// programming. Instead of having separate classes for stationary and
// mobile dummies, they are distinguished using the flag "alive".  You
// probably do not want to base your solution on this class.

public class Dummy extends Entity
{
    private int moveDelay;
    private final boolean alive;

    public
    Dummy(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/unknown.gif"));
        this.alive   = true;
        moveDelay    = 10;
    }

    public
    Dummy(Pasture pasture, boolean alive)
    {
        super(pasture, new ImageIcon("img/unknown.gif"));
        this.alive   = alive;
        moveDelay    = 10;
    }

    public void
    tick()
    {
        if (alive)
        {
            --moveDelay;
        }

        if (moveDelay == 0)
        {
            Point neighbour = Util.getRandomMember(pasture.getFreeNeighbours(this));
            if (neighbour != null)
            {
                pasture.moveEntity(this, neighbour);
            }

            moveDelay = 10;
        }
    }
}
