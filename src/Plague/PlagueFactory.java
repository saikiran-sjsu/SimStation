package Plague;

import SimStation.SimulationFactory;
import mvc.*;

public class PlagueFactory extends SimulationFactory {

    @Override
    public Model makeModel() {
        return new Plague();
    }
}
