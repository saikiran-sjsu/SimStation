package RandomWalk;

import SimStation.Agent;
import SimStation.Heading;
import SimStation.Simulation;

import java.util.Random;

public class Drunk extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Drunk(Simulation thisSimulation) {
		super("Drunk", thisSimulation);
	}

	@Override
	public void update() {
		Random rand = new Random();
		this.setHeading(Heading.getRandomHeading());
		this.move(rand.nextInt(11) + 1);
	}

}
