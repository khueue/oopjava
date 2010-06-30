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
        frame.setLocation(25, 25);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        frame.setContentPane(board);

        frame.setVisible(true);
    }
}
