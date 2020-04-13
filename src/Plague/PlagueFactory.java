package Plague;

import SimStation.SimulationFactory;
import mvc.*;

public class PlagueFactory extends SimulationFactory {

    @Override
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public View getView(Model model) {
        return new PlagueView((PlagueSimulation) model);
    }
}
