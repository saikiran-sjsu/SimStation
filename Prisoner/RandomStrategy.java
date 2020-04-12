package Prisoner;

import java.util.Random;

public class RandomStrategy extends Strategy{

	private Random rand;
	public RandomStrategy(Prisoner owner) {
		super(owner);
		rand = new Random();
	}

	@Override
	public void algo() {
		Prisoner prisoner1 = this.owner;
		Prisoner prisoner2 = prisoner1.getNeighbour();
		int num1 = rand.nextInt(2);
		int num2 = rand.nextInt(2);
		
		if(num1 == 0 && num2 == 0) {
			//Both Cooperate
			prisoner1.addFitness(3);
			prisoner2.addFitness(3);
			prisoner1.cooperate();
			prisoner2.cooperate();
		} else if(num1 == 0 && num2 == 1) {
			//Prisoner 1 cooperate and Prisoner 2 cheat
			prisoner1.addFitness(0);
			prisoner2.addFitness(5);
			prisoner1.cooperate();
			prisoner2.cheat();
		} else if(num1 == 1 && num2 == 0) {
			//Prisoner 1 cheat and Prisoner 2 cooperate
			prisoner1.addFitness(5);
			prisoner2.addFitness(0);
			prisoner1.cheat();
			prisoner2.cooperate();
		} else {
			//Both cheat
			prisoner1.addFitness(1);
			prisoner2.addFitness(1);
			prisoner1.cheat();
			prisoner2.cheat();
		}
	}

}
