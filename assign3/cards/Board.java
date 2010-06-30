/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.util.LinkedList;
import java.awt.Graphics;
import javax.swing.JLayeredPane;

public class Board extends JLayeredPane
{
    public
    Board()
    {
        String[] faces = { "s1",   "d2",   "h3",   "c4",   "jr"   };
        String[] backs = { "b1fv", "b2fv", "b2fv", "b1fv", "b2fv" };

        for (int i = 0; i < faces.length; ++i)
        {
            Card c = new Card(this, path(faces[i]), path(backs[i]));
            c.setLocation(rand(), rand());
            add(c);
        }
    }

    public void
    notifyChange(Card card)
    {
        moveToFront(card);
    }

    protected Integer
    rand()
    {
        return Util.randomIntegerBetween(10, 400);
    }

    protected String
    path(String name)
    {
        return "./cards/img/" + name + ".gif";
    }
}
