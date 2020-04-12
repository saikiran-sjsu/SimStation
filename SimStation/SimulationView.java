package SimStation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

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
		Color oldColor = gc.getColor();
		Simulation sim = (Simulation) model;
		LinkedList<Agent> agents = sim.getAgents();
		gc.setColor(Color.RED);
		for(Agent a : agents) {
			gc.fillOval(a.getX(), a.getY(), Simulation.SHAPE_SIZE, Simulation.SHAPE_SIZE);
		}
		gc.setColor(oldColor);
	}

}
