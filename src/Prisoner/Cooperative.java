package Prisoner;

public class Cooperative extends Strategy{

	public Cooperative(Prisoner owner) {
		super(owner);
	}

	@Override
	public void algo() {
		Prisoner prisoner1 = this.owner;
		Prisoner prisoner2 = prisoner1.getNeighbour();
		prisoner1.addFitness(3);
		prisoner2.addFitness(3);
		prisoner1.cooperate();
		prisoner2.cooperate();
	}

}
