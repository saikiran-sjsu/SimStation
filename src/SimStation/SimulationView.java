package SimStation;

import java.awt.Dimension;
import java.awt.Graphics;

import mvc.Model;
import mvc.View;

public class SimulationView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimulationView(Model model) {
		super(model);
		setPreferredSize(new Dimension(Simulation.WORLD_SIZE, Simulation.WORLD_SIZE));
	}
	
	@Override 
	public void paintComponent(Graphics gc) {
		
	}

}
