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
        final int width  = 500;
        final int height = 500;

        JFrame frame = new JFrame("Plocka med kort");
        frame.setLocation(25, 25);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        board.setSize(width, height);
        board.setLayout(null);
        frame.setContentPane(board);

        frame.setVisible(true);
    }
}
