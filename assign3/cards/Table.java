/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.util.*;
import javax.swing.*;

public class Table
{
    protected JFrame frame;
    protected JPanel content;
    protected Collection<Card> cards = new ArrayList<Card>();

    public
    Table()
    {
        frame = new JFrame();
        frame.setLocation(50, 50);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        content = new JPanel();
        content.setLayout(null);
        frame.add(content);

        Card c;

        c = new Card(path("s1"), path("b1fv"));
        c.setLocation(rand(), rand());
        cards.add(c);

        c = new Card(path("s2"), path("b1fv"));
        c.setLocation(rand(), rand());
        content.add(c);

        for (Card card : cards)
        {
            content.add(card);
        }

        frame.setVisible(true);
    }

    protected Integer
    rand()
    {
        return Util.randomIntegerBetween(0, 300);
    }

    protected String
    path(String name)
    {
        return "./cards/img/" + name + ".gif";
    }
}
