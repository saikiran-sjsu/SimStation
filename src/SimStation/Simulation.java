package SimStation;

import java.util.*;
import mvc.*;

public class Simulation extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Integer WORLD_SIZE = 250; 
	public static Integer SHAPE_SIZE = 5;
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
		if(!agents.isEmpty()) {
			agents.clear();
			clock = 0;
			startTimer();
		}


    	this.populate();
    	for(Agent a : agents) {
    		Thread thread = new Thread(a);
    		thread.start();
    		a.start();
    	}
    }
    
	public void suspend() {
		for(Agent a : agents) {
    		a.suspend();
    	}
		stopTimer();
	}
	
	public void resume() {
		startTimer();
		for(Agent a : agents) {
    		a.resume();
    	}

	}
	
	public void stop() {
		stopTimer();
		for(Agent a : agents) {
			a.stop();
		}



		System.out.println("Stopped");	
	}
	
	public String[] getStats() {
	  String[] stats = new String[2];
	  stats[0] = "#agents = " + agents.size();
	  stats[1] = "clock = " + clock;
	  return stats;
	}
	
	public LinkedList<Agent> getAgents() {
		return this.agents;
	}
	
	public int getClock() {
		return clock;
	}
	
	public Agent getNeighbor(Agent a, int distance) {
		int closestDist = distance;
		int xDist = 0;
		int yDist = 0;
		int totalDist = 0;
		Agent closestAgent = a;

		for(Agent g : agents) {
			if(a == g) {
				continue;
			}
			xDist = Math.abs(a.getX() - g.getX());
			yDist = Math.abs(a.getY() - g.getY());
			totalDist = xDist + yDist;
			if(totalDist < closestDist) {
				closestDist = totalDist;
				closestAgent = g;
			}
		}
		return closestAgent;
	}

	public void addAgent(Agent a) {
		this.agents.add(a);
	}
	
	public void populate() {}
    
  private class ClockUpdater extends TimerTask {
	  public void run() {
		  clock++;
		  //changed();
      }
  }

}
