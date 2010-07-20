/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import java.awt.*;
import javax.swing.*;

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
