/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Sheep extends Entity
{
    protected Integer moveDelay;

    public
    Sheep(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/sheep.gif"));
        moveDelay = 10;
    }

    public void
    tick()
    {
        if (--moveDelay == 0)
        {
            Point free =
                Util.getRandomMember(pasture.getFreeAdjacentPositions(this));
            if (free != null)
            {
                pasture.moveEntity(this, free);
            }
            moveDelay = 10;
        }
    }
}
