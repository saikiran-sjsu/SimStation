package Prisoner;

import SimStation.Agent;
import SimStation.Heading;
import SimStation.Simulation;

import java.util.LinkedList;
import java.util.Random;

public class Prisoner extends Agent{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int fitness;
	private boolean isCooperate;	//keeps track of what opponent did last game
	private Random rand;
	private Strategy strategy;
	private Simulation sim;

	public Prisoner(Simulation thisSimulation) {
		super("Prisoner",thisSimulation);
		fitness = 0;
		this.isCooperate = false;
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		this.strategy = pickStrategy();
		sim = this.getWorld();
	}

	@Override
	public void update() {
		synchronized(strategy) {
			if(((sim.getClock() % 100) == 0) && (this.getWorld().getAgents().getFirst().equals(this))) {
				try {
					Thread.sleep(1000);
					printScore();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		playGame();
		this.setHeading(Heading.getRandomHeading());
		this.move(rand.nextInt(11) + 1);
	}

	private Strategy pickStrategy() {
		rand.setSeed(System.nanoTime());
		int num = rand.nextInt(4);
		if(num == 0) {
			return new Selfish(this);
		} else if(num == 1) {
			return new Cooperative(this);
		} else if(num == 2) {
			return new RandomStrategy(this);
		} else {
			return new Reciprocal(this);
		}
	}

	public void playGame() {
		Prisoner neighbor = (Prisoner) sim.getNeighbor(this, Integer.MAX_VALUE);
		if(this.cooperate() && neighbor.cooperate()) {
			//Both Cooperate
			this.addFitness(3);
			this.setCooperate(true);
			neighbor.addFitness(3);
			neighbor.setCooperate(true);
		} else if(this.cooperate() && !neighbor.cooperate()) {
			//Prisoner1 cooperate while prisoner2 cheat
			this.setCooperate(false);
			neighbor.addFitness(5);
			neighbor.setCooperate(true);
		} else if(!this.cooperate() && neighbor.cooperate()) {
			//Prisoner1 cheat while prisoner2 cooperate
			this.addFitness(5);
			this.setCooperate(true);
			neighbor.setCooperate(false);
		} else {
			//Both Cheat
			this.addFitness(1);
			this.setCooperate(false);
			neighbor.addFitness(1);
			neighbor.setCooperate(false);
		}
	}

	public boolean cooperate() {
		return this.strategy.algorithm();
	}

	public void addFitness(int score) {
		this.fitness += score;
	}

	public String getStrategy() {
		return this.strategy.getName();
	}

	public int getFitness() {
		return this.fitness;
	}

	public boolean isCooperated() {
		return this.isCooperate;
	}

	public void setCooperate(boolean cooperate) {
		this.isCooperate = cooperate;
	}
	
	public double getSelfishAvg() {
		LinkedList<Agent> temp = this.getWorld().getAgents();
		double total = 0.0;
		int num = 0;
		for(Agent a : temp) {
			Prisoner p = (Prisoner) a;
			if(p.getStrategy().equals("Selfish")) {
				total += p.getFitness();
				num++;
			}
		}
		return Math.round((total / num * 10)) / 10.0 ;
	}
	
	public double getCooperateAvg() {
		LinkedList<Agent> temp = this.getWorld().getAgents();
		double total = 0.0;
		int num = 0;
		for(Agent a : temp) {
			Prisoner p = (Prisoner) a;
			if(p.getStrategy().equals("Cooperative")) {
				total += p.getFitness();
				num++;
			}
		}
		return Math.round((total / num * 10)) / 10.0 ;
	}
	
	public double getRandomAvg() {
		LinkedList<Agent> temp = this.getWorld().getAgents();
		double total = 0.0;
		int num = 0;
		for(Agent a : temp) {
			Prisoner p = (Prisoner) a;
			if(p.getStrategy().equals("Random")) {
				total += p.getFitness();
				num++;
			}
		}
		return Math.round((total / num * 10)) / 10.0 ;
	}
	
	public double getReciprocalAvg() {
		LinkedList<Agent> temp = this.getWorld().getAgents();
		double total = 0.0;
		int num = 0;
		for(Agent a : temp) {
			Prisoner p = (Prisoner) a;
			if(p.getStrategy().equals("Reciprocal")) {
				total += p.getFitness();
				num++;
			}
		}
		return Math.round((total / num * 10)) / 10.0 ;
	}

	private void printScore() {

		System.out.println("====================================");
		System.out.println("|| Strategy    ||   Average Score ||");
		System.out.println("====================================");
		System.out.println("|| Selfish     ||      " + this.getSelfishAvg() + "           ||");
		System.out.println("|| Cooperative ||      " + this.getCooperateAvg() + "           ||");
		System.out.println("|| Random      ||      " + this.getRandomAvg() + "           ||");
		System.out.println("|| Reciprocal  ||      " + this.getReciprocalAvg() + "           ||");
		System.out.println("====================================");
		System.out.println();
	}
}