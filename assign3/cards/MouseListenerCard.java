/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.awt.*;
import java.awt.event.*;

class MouseListenerCard implements MouseListener, MouseMotionListener
{
    protected Card card;
    protected Point current;
    protected Point previous;

    public
    MouseListenerCard(Card card)
    {
        Util.throwIfNull(card);
        this.card = card;
    }

    protected void
    setCurrentState(MouseEvent mouse)
    {
        mouse.translatePoint(card.getX(), card.getY()); // Absolute position.
        current = mouse.getPoint();
    }

    protected void
    updatePreviousState()
    {
        previous = current;
    }

    public void
    mouseClicked(MouseEvent mouse)
    {
        card.flip();
    }

    public void
    mousePressed(MouseEvent mouse)
    {
        setCurrentState(mouse);
        updatePreviousState();
    }

    public void
    mouseDragged(MouseEvent mouse)
    {
        setCurrentState(mouse);
        Integer deltaX = (int)(current.getX() - previous.getX());
        Integer deltaY = (int)(current.getY() - previous.getY());
        card.moveByDelta(deltaX, deltaY);
        updatePreviousState();
    }

    public void
    mouseReleased(MouseEvent mouse)
    {
    }

    public void
    mouseMoved(MouseEvent mouse)
    {
    }

    public void
    mouseEntered(MouseEvent mouse)
    {
    }

    public void
    mouseExited(MouseEvent mouse)
    {
    }
}
