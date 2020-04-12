package Flocking;

import SimStation.Agent;
import SimStation.Heading;
import SimStation.Simulation;

import java.util.Random;

public class Bird extends Agent{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Random rand = new Random();

    public int speed;
    public Heading head;

    private Bird neighbor = this;

    public Bird(Simulation thisSimulation) {
        super("Bird", thisSimulation);
        speed = rand.nextInt(11) + 1;
        head = Heading.getRandomHeading();
    }

    @Override
    public void update() {
        neighbor = (Bird) world.getNeighbor(this);
        speed = neighbor.speed;
        head = neighbor.head;
        this.setHeading(head);

        this.move(speed);
    }

}
