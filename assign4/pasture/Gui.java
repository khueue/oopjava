/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import pasture.entity.*;

public class Gui extends JFrame implements ActionListener
{
    private final ImageIcon ICON_EMPTY = new ImageIcon("img/empty.gif");
    private final int SCALE = 30;
    private final Engine engine;

    private final JLabel[][] grid;
    private final Map<Point, java.util.List<ImageIcon>> icons =
        new HashMap<Point, java.util.List<ImageIcon>>();

    private final JLabel  clockLabel    = new JLabel("Time: 0");
    private final JLabel  entitiesLabel = new JLabel("Entities: 0");
    private final JButton startButton   = new JButton("Start");
    private final JButton stopButton    = new JButton("Stop");
    private final JButton exitButton    = new JButton("Exit");

    private final int height;
    private final int width;
    private int numEntities = 0;

    /**
     * Creates a new instance of this class with the specified
     * settings for the pasture to display.
     */
    public
    Gui(int width, int height, Engine engine)
    {
        this.height = height;
        this.width = width;

        this.engine = engine;

        setSize(width*SCALE, height*SCALE);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        exitButton.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 5));
        buttons.add(clockLabel);
        buttons.add(entitiesLabel);
        buttons.add(startButton);
        buttons.add(stopButton);
        buttons.add(exitButton);

        JPanel field = new JPanel();
        field.setBackground(new Color(27, 204, 89));
        field.setLayout(new GridLayout(height, width));
        grid = new JLabel[width][height];

        for (int y = 0; y < height; ++y)
        {
            for (int x = 0; x < width; ++x)
            {
                JLabel label = new JLabel(ICON_EMPTY);
                label.setVisible(true);
                field.add(label);
                grid[x][y] = label;
            }
        }

        setBackground(new Color(27, 204, 89));
        setLayout(new BorderLayout());
        add(field, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        exitButton.setEnabled(true);

        update();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This method is called when an action event has occured and
     * carries out the correct actions depending on the event. In this
     * class, this means that someone has pressed any of the buttons
     * start, stop, or exit.
     */
    public void
    actionPerformed(ActionEvent e)
    {
        if (e.getSource() == startButton)
        {
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            exitButton.setEnabled(true);
            engine.start();
        }
        else if (e.getSource() == stopButton)
        {
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            exitButton.setEnabled(true);
            engine.stop();
        }
        else if (e.getSource() == exitButton)
        {
            System.exit(0);
        }
    }

    /**
     * The method addEntity is called to notify the GUI that an entity
     * has been added to a position. The icon of the added entity is
     * displayed at the position.
     */
    public void
    addEntity(IEntity entity, Point pos)
    {
        ImageIcon icon = entity.getImage();

        java.util.List<ImageIcon> list = icons.get(pos);
        if (list == null)
        {
            list = new ArrayList<ImageIcon>();
            icons.put(pos, list);
        }
        list.add(icon);

        grid[pos.x][pos.y].setIcon(icon);

        ++numEntities;

        //display.moveToFront(entity);
    }

    /**
     * The method removeEntity is called to notify the GUI that an
     * entity has been removed from a position. One icon among the
     * icons of the remaining entities is displayed at the position.
     */
    public void
    removeEntity(IEntity entity, Point pos)
    {
        ImageIcon icon = entity.getImage();

        java.util.List<ImageIcon> list = icons.get(pos);
        list.remove(icon);

        icon = list.isEmpty() ? ICON_EMPTY : list.get(0);
        grid[pos.x][pos.y].setIcon(icon);

        --numEntities;
    }

    public void
    moveEntity(IEntity entity, Point oldPos, Point newPos)
    {
        removeEntity(entity, oldPos);
        addEntity(entity, newPos);
    }

    public void
    update()
    {
        clockLabel.setText("Time: " + engine.getTime());
        entitiesLabel.setText("Entities: " + numEntities);
    }
}
