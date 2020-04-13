package Prisoner;

public class Cooperative extends Strategy{

	public Cooperative(Prisoner owner) {
		super(owner);
	}

	@Override
	public String getName() {
		return "Cooperative";
	}

	@Override
	public boolean algorithm() {
		return true;
	}

}
