/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.awt.Color;
import javax.swing.JLayeredPane;

public class Board extends JLayeredPane
{
    public
    Board()
    {
        configurePanel();
        createDeck();
    }

    protected void
    configurePanel()
    {
        setLayout(null); // So we can decide exact positions.
        setOpaque(true); // Must be opaque for background color.
        setBackground(Color.GREEN);
    }

    protected void
    createDeck()
    {
        createSuit("c", "b1fv"); // Clubs.
        createSuit("s", "b1fv"); // Spades.
        createSuit("d", "b2fv"); // Diamonds.
        createSuit("h", "b2fv"); // Hearts.
    }

    protected void
    createSuit(String prefix, String back)
    {
        final String[] CARD_RANKS =
        {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "j", "q", "k",
        };

        for (String rank : CARD_RANKS)
        {
            String face = prefix + rank;
            createCard(path(face), path(back));
        }
    }

    protected void
    createCard(String faceImagePath, String backImagePath)
    {
        Card c = new Card(this, faceImagePath, backImagePath);
        c.setLocation(rand(), rand());
        super.add(c);
    }

    protected Integer
    rand()
    {
        return Util.randomIntegerBetween(10, 375);
    }

    protected String
    path(String name)
    {
        return "./img/" + name + ".gif";
    }

    public void
    notifyChangedCard(Card card)
    {
        super.moveToFront(card);
    }
}
