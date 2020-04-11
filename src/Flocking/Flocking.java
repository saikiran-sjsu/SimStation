package Flocking;

import SimStation.*;

public class Flocking extends Simulation {

    public void populate() {
        // TODO
    }

    public static void main(String[] args) {
        SimulationPanel simPanel = new SimulationPanel(new FlockingFactory());
        simPanel.display();
    }
}
