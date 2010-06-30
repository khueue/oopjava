/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Card extends JPanel
{
    protected Board board;
    protected ImageIcon face;
    protected ImageIcon back;
    protected ImageIcon visibleSide;

    public
    Card(Board board, String pathFace, String pathBack)
    {
        this.board = board;
        face = new ImageIcon(pathFace);
        back = new ImageIcon(pathBack);
        setVisibleSide(face);

        CardMouseListener listener = new CardMouseListener(this);
        super.addMouseListener(listener);
        super.addMouseMotionListener(listener);
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
        super.setLocation(newX, newY);
        board.notifyChangedCard(this);
    }

    public void
    flip()
    {
        setVisibleSide(otherSide());
        board.notifyChangedCard(this);
    }

    protected void
    setVisibleSide(ImageIcon icon)
    {
        visibleSide = icon;
        super.setSize(icon.getIconWidth(), icon.getIconHeight());
    }

    protected ImageIcon
    otherSide()
    {
        return (visibleSide == face) ? back : face;
    }
}
