/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import javax.swing.JFrame;

abstract public class Main
{
    static public void
    main(String[] args)
    {
        JFrame frame = new JFrame("Plocka med kort");
        frame.setLocation(50, 50);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Table table = new Table();
        frame.setContentPane(table);

        frame.setVisible(true);
    }
}
