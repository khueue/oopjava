/**
 * OOPJAVA - Assignment 3
 * Sebastian Lundström (selu7901)
 */

package cards;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract public class Cards
{
    static public void
    main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel content = new JPanel();
        content.setLayout(null);
        frame.add(content);

        Card card; // xxxxxx
        card = new Card("s1.gif", "b1fv.gif");
        card.setLocation(100, 100);
        content.add(card);
    }
}

class MouseListenerCard implements MouseListener, MouseMotionListener
{
    protected Card card;
    protected Integer x;
    protected Integer y;
    protected Integer prevX;
    protected Integer prevY;

    public
    MouseListenerCard(Card card)
    {
        Util.throwIfNull(card);
        this.card = card;
    }

    protected void
    setEventDetails(MouseEvent event)
    {
        event.translatePoint(card.getX(), card.getY());
        x = event.getX();
        y = event.getY();
    }

    public void
    mouseClicked(MouseEvent event)
    {
        setEventDetails(event);
        card.flip();
        System.out.println("mouse clicked, x:" + x + ", y:" + y);
    }

    public void
    mousePressed(MouseEvent event)
    {
        setEventDetails(event);
        prevX = x;
        prevY = y;
        System.out.println("mouse pressed, x:" + x + ", y:" + y);
    }

    public void
    mouseDragged(MouseEvent event)
    {
        setEventDetails(event);
        System.out.println("mouse dragged, x:" + x + ", y:" + y);
        Integer deltaX = x - prevX;
        Integer deltaY = y - prevY;
        card.move(deltaX, deltaY);
        prevX += deltaX;
        prevY += deltaY;
    }

    public void
    mouseReleased(MouseEvent event)
    {
        // setEventDetails(event);
    }

    public void
    mouseMoved(MouseEvent event)
    {
        // setEventDetails(event);
    }

    public void
    mouseEntered(MouseEvent event)
    {
        // setEventDetails(event);
    }

    public void
    mouseExited(MouseEvent event)
    {
        // setEventDetails(event);
    }
}

class Card extends JPanel
{
    static public final String IMG_PATH = "cards/img/";

    protected ImageIcon front;
    protected ImageIcon back;
    protected ImageIcon currentVisible;

    public
    Card(String frontFilename, String backFilename)
    {
        front = new ImageIcon(IMG_PATH + frontFilename);
        back  = new ImageIcon(IMG_PATH + backFilename);
        setCurrentVisible(front);

        MouseListenerCard ma = new MouseListenerCard(this);
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public void
    move(Integer dx, Integer dy)
    {
        Integer newX = getX() + dx;
        Integer newY = getY() + dy;
        setLocation(newX, newY);
    }

    protected void
    setCurrentVisible(ImageIcon icon)
    {
        currentVisible = icon;
        setSize(icon.getIconWidth(), icon.getIconHeight());
    }

    public void
    flip()
    {
        ImageIcon other = (currentVisible == front) ? back : front;
        setCurrentVisible(other);
        paintComponent(getGraphics());
    }

    public void
    paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(currentVisible.getImage(), 0, 0, this);
    }
}
