package Plague;

import SimStation.*;
import mvc.AppPanel;

public class Plague extends Agent {


    private boolean infected;

    public Plague(Simulation thisSimulation) {

        super("Plague", thisSimulation);

    }

    public boolean isInfected() {return infected;}

    @Override
    public void update() {

    }
}
