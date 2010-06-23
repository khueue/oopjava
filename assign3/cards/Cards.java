/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.awt.*;
import javax.swing.*;

public class Cards
{
    public static void
    main(String[] args)
    {
        Util.throwIfNull(new JFrame("asf"));
        System.out.println("Hej.");

        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JPanel(new BorderLayout()), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
