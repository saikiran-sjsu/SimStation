package Prisoner;

public class Selfish extends Strategy{

	public Selfish(Prisoner owner) {
		super(owner);
	}

	@Override
	public void algo() {
		Prisoner prisoner1 = this.owner;
		Prisoner prisoner2 = this.owner.getNeighbour();
		prisoner1.addFitness(1);
		prisoner2.addFitness(1);
		prisoner1.cheat();
		prisoner2.cheat();
	}

}
