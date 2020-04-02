package mvc;

public abstract class Command {
	
	protected Model model;
	
	public Command(Model model) {
		super();
		this.model = model;
	}
	
	public String toString() {
		return "Command model = " + model;
	}
	
	public abstract void execute();
}
