package RandomWalk;

import SimStation.Agent;
import SimStation.Heading;
import java.util.Random;

public class Drunk extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Drunk() {
		super("Drunk");
		
	}

	@Override
	public void update() {
		Random rand = new Random();
		this.setHeading(Heading.getRandomHeading());
		this.move(rand.nextInt(11) + 1);
	}

}
