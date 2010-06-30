/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

class Card extends JPanel
{
    protected Table table;
    protected ImageIcon face;
    protected ImageIcon back;
    protected ImageIcon visibleSide;

    public
    Card(Table table, String pathFace, String pathBack)
    {
        this.table = table;
        face = new ImageIcon(pathFace);
        back = new ImageIcon(pathBack);
        setVisibleSide(face);

        MouseListenerCard listener = new MouseListenerCard(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public void
    paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(visibleSide.getImage(), 0, 0, this);
    }

    public void
    moveByDelta(Integer deltaX, Integer deltaY)
    {
        Integer newX = getX() + deltaX;
        Integer newY = getY() + deltaY;
        setLocation(newX, newY);
        table.notifyChange(this);
    }

    public void
    flip()
    {
        setVisibleSide(otherSide());
        table.notifyChange(this);
    }

    protected void
    setVisibleSide(ImageIcon icon)
    {
        visibleSide = icon;
        setSize(icon.getIconWidth(), icon.getIconHeight());
    }

    protected ImageIcon
    otherSide()
    {
        return (visibleSide == face) ? back : face;
    }
}
