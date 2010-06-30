/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.awt.*;
import javax.swing.*;

abstract public class Main
{
    static public void
    main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setLocation(50, 50);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(null);
        frame.add(content);

        Card card; // xxxxxx
        card = new Card(path("s1"), path("b1fv"));
        card.setLocation(pos(), pos());
        content.add(card);
        card = new Card(path("s2"), path("b1fv"));
        card.setLocation(pos(), pos());
        content.add(card);

        frame.setVisible(true);
    }

    static protected Integer
    pos()
    {
        return Util.randomIntegerBetween(0, 300);
    }

    static protected String
    path(String name)
    {
        return "./cards/img/" + name + ".gif";
    }
}
