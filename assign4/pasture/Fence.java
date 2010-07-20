/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Fence extends Entity
{
    public
    Fence(Pasture pasture)
    {
        super(pasture, new ImageIcon("img/fence.gif"));
    }

    public void
    tick()
    {
    }
}
