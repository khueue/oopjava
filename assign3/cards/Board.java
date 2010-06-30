/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import javax.swing.JLayeredPane;

public class Board extends JLayeredPane
{
    static protected final String[] CARD_RANKS =
        { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k" };

    public
    Board()
    {
        createSuit("c", "b1fv"); // Clubs.
        createSuit("s", "b1fv"); // Spades.
        createSuit("d", "b2fv"); // Diamonds.
        createSuit("h", "b2fv"); // Hearts.
    }

    protected void
    createSuit(String prefix, String back)
    {
        for (String rank : CARD_RANKS)
        {
            String face = prefix + rank;
            Card c = new Card(this, path(face), path(back));
            c.setLocation(rand(), rand());
            super.add(c);
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
        super.moveToFront(card);
    }
}
