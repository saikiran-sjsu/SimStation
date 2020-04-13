package Prisoner;

public class Selfish extends Strategy{

	public Selfish(Prisoner owner) {
		super(owner);
	}

	@Override
	public String getName() {
		return "Selfish";
	}

	@Override
	public boolean algorithm() {
		return false;
	}

}
