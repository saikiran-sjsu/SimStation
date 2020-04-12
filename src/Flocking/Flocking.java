package Flocking;

import SimStation.*;

public class Flocking extends Simulation {

    @Override
    public void populate() {
        for(int i = 0; i < 50; i++) {
            this.addAgent(new Bird(this));
        }
    }

    public static void main(String[] args) {
        SimulationPanel simPanel = new SimulationPanel(new FlockingFactory());
        simPanel.display();
    }
}
