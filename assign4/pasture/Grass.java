/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Grass extends Plant
{
    private Integer ticksUntilReproduce = (int)(1000 * Math.random()) + 100;

    public
    Grass(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/plant.gif"));
    }
}
