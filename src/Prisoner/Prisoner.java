package Prisoner;

import SimStation.Agent;
import SimStation.Heading;
import SimStation.Simulation;
import java.util.Random;

public class Prisoner extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fitness;
	private boolean isCooperated;
	private Prisoner neighbour;
	private Random rand;
	public Prisoner(Simulation thisSimulation) {
		super("Prisoner",thisSimulation);
		fitness = 0;
		isCooperated = false;
		this.neighbour = null;
		rand = new Random();
	}

	@Override
	public void update() {
		Simulation sim = this.getWorld();
		if((sim.getClock() % 100) == 0) {
			printScore();
		}
		neighbour = (Prisoner) sim.getNeighbor(this);
		assert neighbour != null;
		playGame(pickStrategy());
		this.setHeading(Heading.getRandomHeading());
		this.move(rand.nextInt(11) + 1);
	}
	
	private Strategy pickStrategy() {
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
	
	private void playGame(Strategy strategy) {
		strategy.algo();
	}
	
	public boolean isCooperated() {
		return isCooperated;
	}
	
	public void cooperate() {
		this.isCooperated = true;
	}
	
	public void cheat() {
		this.isCooperated = false;
	}
	
	public Prisoner getNeighbour() {
		return this.neighbour;
	}
	
	public void addFitness(int score) {
		this.fitness += score;
	}
	
	private void printScore() {
		int avgScore = this.fitness / 4;
		System.out.println("Average fitness for each strategy type: " + avgScore);
//		System.out.println("Clock: " + this.getWorld().getClock());
//		System.out.println("====================================");
//		System.out.println("|| Strategy    ||   Average Score ||");
//		System.out.println("====================================");
//		System.out.println("|| Selfish     ||      " + avgScore + "           ||");
//		System.out.println("|| Cooperative ||      " + avgScore + "           ||");
//		System.out.println("|| Random      ||      " + avgScore + "           ||");
//		System.out.println("|| Reciprocal  ||      " + avgScore + "           ||");
//		System.out.println("====================================");
//		System.out.println();
	}
}
