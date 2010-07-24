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
    public
    Grass(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/plant.gif"));
    }
}
