/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.awt.*;
import javax.swing.*;
import java.util.*;

// Note that Dummy is a pretty BAD example of object-oriented
// programming. Instead of having separate classes for stationary and
// mobile dummies, they are distinguished using the flag "alive".  You
// probably do not want to base your solution on this class.

public class Dummy extends Entity
{
    /** The number of ticks this entity should get before moving. */
    private int moveDelay;
    private final boolean alive;

    /**
     * Creates a new instance of this class, with the given pasture as
     * its pasture.
     * @param pasture the pasture this entity should belong to.
     */
    public
    Dummy(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/unknown.gif"));
        this.alive   = true;
        moveDelay    = 10;
    }

    /**
     * Creates a new instance of this class, with the given pasture as
     * its pasture, and position as its position.
     * @param pasture the pasture this entity should belong to.
     * @param position the position of this entity.
     */
    public
    Dummy(Pasture pasture, boolean alive)
    {
        super(pasture, new ImageIcon("img/unknown.gif"));
        this.alive   = alive;
        moveDelay    = 10;
    }

    /**
     * Performs the relevant actions of this entity, depending on what
     * kind of entity it is.
     */
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
