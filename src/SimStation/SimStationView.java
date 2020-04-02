package SimStation;

import java.awt.Dimension;
import java.awt.Graphics;

import mvc.Model;
import mvc.View;

public class SimStationView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimStationView(Model model) {
		super(model);
		setPreferredSize(new Dimension(SimStation.WORLD_SIZE, SimStation.WORLD_SIZE));
	}
	
	@Override 
	public void paintComponent(Graphics gc) {
		
	}

}
