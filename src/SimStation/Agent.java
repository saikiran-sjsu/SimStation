package SimStation;

import java.io.Serializable;

public abstract class Agent implements Serializable, Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Heading heading;
	private int xc;
	private int yc;
	private AgentState state;
	private Simulation world;
	
	public Agent(String name) {
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}
	
	public Heading getHeading() {
		return heading;
	}
	
	public int getX() {
		return xc;
	}
	
	public int getY() {
		return yc;
	}
	
	public AgentState getState() {
		return state;
	}
	
	public Simulation getWorld() {
		return world;
	}
	
	public void run() {
		
	}
	
	public void start() {
		
	}
	
	public void suspend() {
		
	}
	
	public void resume() {
		
	}
	
	public void stop() {
		
	}
	
	public abstract void update();
	
	public void move(int steps) {
		
	}

}
