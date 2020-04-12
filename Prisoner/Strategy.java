package Prisoner;

public abstract class Strategy {
	
	protected Prisoner owner;
	
	public Strategy(Prisoner owner) {
		this.owner = owner;
	}
	
	public abstract void algo();
}
