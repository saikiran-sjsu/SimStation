package Prisoner;

public class Reciprocal extends Strategy{

	public Reciprocal(Prisoner owner) {
		super(owner);
	}

	@Override
	public String getName() {
		return "Reciprocal";
	}

	@Override
	public boolean algorithm() {
		Prisoner prisoner = this.owner;
		return prisoner.isCooperated();
	}

}
