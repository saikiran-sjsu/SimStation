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
    private int speed;
    private Bird neighbor;

    public Bird(Simulation thisSimulation) {
        super("Bird", thisSimulation);
        Random rand = new Random();
        speed = rand.nextInt(11) + 1;
        this.setHeading(Heading.getRandomHeading());
    }

    @Override
    public void update() {
        neighbor = (Bird) this.getWorld().getNeighbor(this, 20);
        speed = neighbor.speed;
        this.setHeading(neighbor.getHeading());
        this.move(speed);
    }

}
