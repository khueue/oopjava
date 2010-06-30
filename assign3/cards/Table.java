/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.util.*;
import javax.swing.*;

public class Table
{
    protected JFrame frame = new JFrame();
    protected JPanel content = new JPanel();
    protected Collection<Card> cards = new ArrayList<Card>();

    public
    Table()
    {
        setupFrame();
        setupContent();
        setupCards();
    }

    protected void
    setupFrame()
    {
        frame.setLocation(50, 50);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected void
    setupContent()
    {
        content.setLayout(null); // No weird default layout!
        frame.add(content);
    }

    protected void
    setupCards()
    {
        String[] faces = { "s1", "s2", "s3", "s4", "s5" };
        String back = "b1fv";

        for (String face : faces)
        {
            Card card = new Card(path(face), path(back));
            card.setLocation(rand(), rand());
            content.add(card);
        }
    }

    public void
    show()
    {
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
