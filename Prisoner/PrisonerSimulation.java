package Prisoner;

import SimStation.Simulation;
import SimStation.SimulationPanel;
import mvc.AppPanel;

public class PrisonerSimulation extends Simulation{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void populate() {
		for(int i = 0; i < 50; i++) {
			this.addAgent(new Prisoner(this));
		}
	}
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PrisonerFactory());
		panel.display();
	}

}
