package Prisoner;

import SimStation.Agent;
import SimStation.Simulation;

public class Prisoner extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fitness;

	public Prisoner(Simulation thisSimulation) {
		super("Prisoner",thisSimulation);
		fitness = 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean cooperate() {
		return false;
	}

}
