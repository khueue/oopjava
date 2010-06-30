/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import javax.swing.JLayeredPane;

public class Board extends JLayeredPane
{
    static protected final String[] RANKS =
        { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k" };

    public
    Board()
    {
        createDeck("d", "b2fv");
        createDeck("h", "b2fv");
        createDeck("c", "b1fv");
        createDeck("s", "b1fv");
    }

    protected void
    createDeck(String prefix, String back)
    {
        for (String rank : RANKS)
        {
            String face = prefix + rank;
            Card c = new Card(this, path(face), path(back));
            c.setLocation(rand(), rand());
            add(c);
        }
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

    public void
    notifyChangedCard(Card card)
    {
        moveToFront(card);
    }
}
