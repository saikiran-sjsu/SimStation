package Prisoner;

import SimStation.SimulationFactory;
import mvc.Model;

public class PrisonerFactory extends SimulationFactory{
	@Override
	public Model makeModel() {
		return new PrisonerSimulation();
	}

}
