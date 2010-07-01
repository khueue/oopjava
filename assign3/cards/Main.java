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
        JFrame window = new JFrame("Plocka med kort");
        window.setLocation(15, 15);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        window.add(board);

        window.setVisible(true);
    }
}
