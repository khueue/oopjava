/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.awt.*;
import javax.swing.*;

class Card extends JPanel
{
    protected ImageIcon face;
    protected ImageIcon back;
    protected ImageIcon visibleSide;

    public
    Card(String pathFace, String pathBack)
    {
        face = new ImageIcon(pathFace);
        back = new ImageIcon(pathBack);
        setVisibleSide(face);

        MouseListenerCard listener = new MouseListenerCard(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public void
    moveByDelta(Integer deltaX, Integer deltaY)
    {
        Integer newX = getX() + deltaX;
        Integer newY = getY() + deltaY;
        setLocation(newX, newY);
    }

    protected void
    setVisibleSide(ImageIcon icon)
    {
        visibleSide = icon;
        setSize(icon.getIconWidth(), icon.getIconHeight());
    }

    public void
    flip()
    {
        ImageIcon other = (visibleSide == face) ? back : face;
        setVisibleSide(other);
        paintComponent(getGraphics());
    }

    public void
    paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(visibleSide.getImage(), 0, 0, this);
    }
}
