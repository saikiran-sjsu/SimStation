package RandomWalk;


import SimStation.SimulationFactory;
import mvc.Model;

public class RandomWalkFactory extends SimulationFactory{
	@Override
	public Model makeModel() {
		return new RandomWalk();
	}

}
