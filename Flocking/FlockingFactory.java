package Flocking;

import SimStation.*;
import mvc.Model;

public class FlockingFactory extends SimulationFactory {

    @Override
    public Model makeModel() {
        return new Flocking();
    }
}
