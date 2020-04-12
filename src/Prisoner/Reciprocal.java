package Prisoner;

public class Reciprocal extends Strategy{

	public Reciprocal(Prisoner owner) {
		super(owner);
	}

	@Override
	public void algo() {
		Prisoner prisoner1 = this.owner;
		Prisoner prisoner2 = prisoner1.getNeighbour();
		if(prisoner1.isCooperated()) {
			//Prisoner1 cooperate only if last is cooperate
			prisoner1.addFitness(3);
			prisoner2.addFitness(3);
			prisoner1.cooperate();
			prisoner2.cooperate();
		} else {
			//Prisoner1 cheat
			prisoner1.addFitness(5);
			prisoner2.addFitness(0);
			prisoner1.cheat();
			prisoner2.cooperate();
		}
	}

}
