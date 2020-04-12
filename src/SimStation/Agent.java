package SimStation;

import java.io.Serializable;
import java.util.Random;

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
	private Thread thread;
	private Random rand = new Random();
	
	public Agent(String name, Simulation thisSimulation) {
		this.name = name;
		world = thisSimulation;
		state = AgentState.READY;
		heading = Heading.EAST;
		xc = rand.nextInt(Simulation.WORLD_SIZE);
		yc = rand.nextInt(Simulation.WORLD_SIZE);
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
	
	public synchronized AgentState getState() {
		return state;
	}
	
	public synchronized Simulation getWorld() {
		return world;
	}
	
	public synchronized void setHeading(Heading heading) {
		this.heading = heading;
	}
	
	public synchronized void setXc(int xc) {
		this.xc = xc;
	}
	
	public synchronized void setYc(int yc) {
		this.yc = yc;
	}
	
	public void run() {
		thread = Thread.currentThread(); // catch my thread
		while(!isStopped()) {
			state = AgentState.RUNNING;
			update();
			try {
				Thread.sleep(100); // be cooperative
				synchronized(this) {
					while(isSuspended()) { wait(); }
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public synchronized void start() {
		state = AgentState.RUNNING;
	}
	
	public synchronized void suspend() {
		state = AgentState.SUSPEND;
	}
	
	public synchronized boolean isSuspended() {
		return state == AgentState.SUSPEND;
	}
	
	public synchronized void resume() {
		if (!isStopped()) {
			state = AgentState.READY;
			notify();
		}
	}
	
	public synchronized void stop() {
		state = AgentState.STOPPED;
	}
	
	public synchronized boolean isStopped() {
		return state == AgentState.STOPPED;
	}
	
	public synchronized String toString() { 
		return name + ".state = " + state; 
	}
	
	public synchronized void join() throws InterruptedException {
		if (thread != null) thread.join();
	}
	
	public abstract void update();
	

	public void move(int steps) {
		int xpos = this.xc;
		int ypos = this.yc;
		for(int i = 0; i < steps; i++) {
			if(this.heading == Heading.EAST) {
				if(xpos > Simulation.WORLD_SIZE) 
					xpos = 0;
				xpos += 1;
			} else if(this.heading == Heading.WEST) {
				if(xpos < 0) 
					xpos = Simulation.WORLD_SIZE;
				xpos -= 1;
			} else if(this.heading == Heading.SOUTH) {
				if(ypos > Simulation.WORLD_SIZE) 
					ypos = 0;
				ypos += 1;
			} else {
				if(ypos < 0) 
					ypos = Simulation.WORLD_SIZE;
				ypos -= 1;
			}
			this.xc = xpos;
			this.yc = ypos;
			world.changed();
		}

	}

}
