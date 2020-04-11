package SimStation;

import java.util.*;
import mvc.*;

public class Simulation extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Integer WORLD_SIZE = 250; 
	private Timer timer;
	private int clock;
	private LinkedList<Agent> agents;

	public Simulation() {
		agents = new LinkedList<>();
		startTimer();
		clock = 0;
	}

	private void startTimer() {
	   timer = new Timer();
       timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
	  timer.cancel();
	  timer.purge();
    }
    
    public void start() {
    	for(Agent a : agents) {
    		a.start();
    	}
    }
    
	public void suspend() {
		for(Agent a : agents) {
    		a.suspend();
    	}
	}
	
	public void resume() {
		for(Agent a : agents) {
    		a.resume();
    	}
	}
	
	public void stop() {
		stopTimer();
		for(Agent a : agents) {
    		a.stop();
    	}
	}
	
	public String[] getStats() {
	  String[] stats = new String[2];
	  stats[0] = "#agents = " + agents.size();
	  stats[1] = "clock = " + clock;
	  return stats;
	}
	
	public Agent getNeighbor(Agent a) {
		return null;
	}
	
	public void addAgent(Agent a) {
		this.agents.add(a);
	}
	
	public void populate() {
		
	}
    
  private class ClockUpdater extends TimerTask {
	  public void run() {
		  clock++;
		  //changed();
      }
  }

}
