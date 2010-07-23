/**
 * OOPJAVA - Assignment 4
 * Sebastian Lundström (selu7901)
 */

package pasture;

import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;

/**
 * The simulation is run by an internal timer that sends out a 'tick'
 * with a given interval. One tick from the timer means that each
 * entity in the pasture should obtain a tick. When an entity obtains
 * a tick, this entity is allowed to carry out their tasks according
 * to what kind they are. This could mean moving the entity, making
 * the entity starve from hunger, or producing a new offspring.
 */
public class Engine implements ActionListener
{
    private final Integer SPEED_REFERENCE = 1000;
    private final Integer SPEED = 10;
    private final Timer timer = new Timer(SPEED_REFERENCE/SPEED, this);
    private Integer time = 0;

    private final Pasture pasture;

    public
    Engine(Pasture pasture)
    {
        this.pasture = pasture;
    }

    public void
    actionPerformed(ActionEvent event)
    {
        for (Entity entity : pasture.getEntities())
        {
            entity.tick();
        }
        pasture.refresh();
        ++time;
    }

    public void
    setSpeed(Integer speed)
    {
        timer.setDelay(SPEED_REFERENCE / speed);
    }

    public void
    start()
    {
        setSpeed(SPEED);
        timer.start();
    }

    public void
    stop()
    {
        timer.stop();
    }

    public Integer
    getTime()
    {
        return time;
    }
}
