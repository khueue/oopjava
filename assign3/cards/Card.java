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
        setupMouseListener();
    }

    protected void
    setupMouseListener()
    {
        CardMouseListener listener = new CardMouseListener(this);
        super.addMouseListener(listener);
        super.addMouseMotionListener(listener);
    }

    protected void
    paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(visibleSide.getImage(), 0, 0, this);
    }

    public void
    moveByDelta(Integer dx, Integer dy)
    {
        Integer newX = super.getX() + dx;
        Integer newY = super.getY() + dy;
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
