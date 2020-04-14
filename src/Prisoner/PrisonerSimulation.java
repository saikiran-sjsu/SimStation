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
	
	@Override
	public String[] getStats() {
		 String[] stats = new String[6];
		 Prisoner p = (Prisoner) this.getAgents().getFirst();
		 stats[0] = "#agents = " + this.getAgents().size();
	     stats[1] = "clock = " + this.getClock();
	     stats[2] = "Cheater's Average = " + p.getSelfishAvg();
	     stats[3] = "Cooperator's Average = " + p.getCooperateAvg();
	     stats[4] = "Reciproicator's Average = " + p.getReciprocalAvg();
	     stats[5] = "Random's Average = " + p.getRandomAvg();
		 return stats;
	}
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PrisonerFactory());
		panel.display();
	}

}
