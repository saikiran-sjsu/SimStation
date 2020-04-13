package Prisoner;

import java.util.Random;

public class RandomStrategy extends Strategy{

	private Random rand;
	public RandomStrategy(Prisoner owner) {
		super(owner);
		rand = new Random();
	}

	@Override
	public String getName() {
		return "Random";
	}

	@Override
	public boolean algorithm() {
		rand.setSeed(System.nanoTime());
		return rand.nextBoolean();
	}

}
