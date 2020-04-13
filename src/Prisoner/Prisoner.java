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
	private boolean isCooperate;
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
			this.setCooperate(true);
			neighbor.addFitness(5);
			neighbor.setCooperate(false);
		} else if(!this.cooperate() && neighbor.cooperate()) {
			//Prisoner1 cheat while prisoner2 cooperate
			this.addFitness(5);
			this.setCooperate(false);
			neighbor.setCooperate(true);
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

	private void printScore() {
		LinkedList<Agent> temp = this.getWorld().getAgents();
		int selfishScore = 0;
		int numSelfish = 0;
		int cooperativeScore = 0;
		int numCooperative = 0;
		int randomScore= 0;
		int numRandom = 0;
		int reciprocalScore = 0;
		int numReciprocal = 0;

		for(Agent a : temp) {
			Prisoner p = (Prisoner) a;
			String stra = p.getStrategy();
			if(stra.equals("Selfish")) {
				selfishScore += p.getFitness();
				numSelfish++;
			} else if(stra.equals("Cooperative")) {
				cooperativeScore += p.getFitness();
				numCooperative++;
			} else if(stra.equals("Random")) {
				randomScore += p.getFitness();
				numRandom++;
			} else {
				reciprocalScore += p.getFitness();
				numReciprocal++;
			}
		}

		System.out.println("====================================");
		System.out.println("|| Strategy    ||   Average Score ||");
		System.out.println("====================================");
		System.out.println("|| Selfish     ||      " + selfishScore / numSelfish + "           ||");
		System.out.println("|| Cooperative ||      " + cooperativeScore / numCooperative + "           ||");
		System.out.println("|| Random      ||      " + randomScore / numRandom + "           ||");
		System.out.println("|| Reciprocal  ||      " + reciprocalScore /  numReciprocal + "           ||");
		System.out.println("====================================");
		System.out.println();
	}
}